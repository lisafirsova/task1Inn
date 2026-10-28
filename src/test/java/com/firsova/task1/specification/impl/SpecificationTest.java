package com.firsova.task1.specification.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.repository.ArrayRepository;
import com.firsova.task1.repository.impl.ArrayRepositoryImpl;
import com.firsova.task1.specification.ArraySpecification;
import com.firsova.task1.warehouse.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.firsova.task1.specification.ComparisonType.EQUAL;
import static com.firsova.task1.specification.ComparisonType.GREATER;
import static com.firsova.task1.specification.ComparisonType.LESS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecificationTest {
    private final ArrayRepository repository = ArrayRepositoryImpl.getInstance();

    @BeforeEach
    void setUp() {
        repository.add(new ArrayInt(1, new int[]{1, 2, 3}));      // sum 6,  avg 2, min 1,  max 3,  count 3
        repository.add(new ArrayInt(2, new int[]{10, -4}));       // sum 6,  avg 3, min -4, max 10, count 2
        repository.add(new ArrayInt(3, new int[]{5, 5, 5, 5}));   // sum 20, avg 5, min 5,  max 5,  count 4
        repository.add(new ArrayInt(4, new int[0]));              // empty: no statistics, count 0
    }

    @AfterEach
    void tearDown() {
        repository.clear();
        Warehouse.getInstance().clear();
    }

    @Test
    void idSpecificationFindsArrayById() {
        assertEquals(List.of(2), findIds(new IdSpecification(2)));
        assertEquals(List.of(), findIds(new IdSpecification(99)));
    }

    @Test
    void sumSpecificationComparesSum() {
        assertEquals(List.of(3), findIds(new SumSpecification(GREATER, 6)));
        assertEquals(List.of(1, 2), findIds(new SumSpecification(EQUAL, 6)));
        assertEquals(List.of(1, 2), findIds(new SumSpecification(LESS, 20)));
    }

    @Test
    void averageSpecificationComparesAverage() {
        assertEquals(List.of(2, 3), findIds(new AverageSpecification(GREATER, 2)));
        assertEquals(List.of(3), findIds(new AverageSpecification(EQUAL, 5)));
        assertEquals(List.of(1), findIds(new AverageSpecification(LESS, 2.5)));
    }

    @Test
    void maxSpecificationComparesMax() {
        assertEquals(List.of(2), findIds(new MaxSpecification(GREATER, 5)));
        assertEquals(List.of(3), findIds(new MaxSpecification(EQUAL, 5)));
        assertEquals(List.of(1), findIds(new MaxSpecification(LESS, 5)));
    }

    @Test
    void minSpecificationComparesMin() {
        assertEquals(List.of(3), findIds(new MinSpecification(GREATER, 1)));
        assertEquals(List.of(1), findIds(new MinSpecification(EQUAL, 1)));
        assertEquals(List.of(2), findIds(new MinSpecification(LESS, 0)));
    }

    @Test
    void countSpecificationComparesNumberOfElements() {
        assertEquals(List.of(1, 3), findIds(new CountSpecification(GREATER, 2)));
        assertEquals(List.of(4), findIds(new CountSpecification(EQUAL, 0)));
        assertEquals(List.of(2, 4), findIds(new CountSpecification(LESS, 3)));
    }

    @Test
    void statisticsSpecificationsSkipEmptyArray() {
        assertEquals(List.of(1, 2, 3), findIds(new SumSpecification(GREATER, -100)));
        assertEquals(List.of(1, 2, 3), findIds(new MinSpecification(LESS, 100)));
    }

    @Test
    void specificationSeesUpdatedStatisticsAfterElementChange() throws Exception {
        ArrayInt array = repository.findBy(new IdSpecification(1)).get(0);

        array.setElement(0, 100);

        assertEquals(List.of(1, 3), findIds(new SumSpecification(GREATER, 6)));
    }

    private List<Integer> findIds(ArraySpecification specification) {
        return repository.findBy(specification).stream()
                .map(ArrayInt::getArrayId)
                .sorted()
                .toList();
    }
}
