package org.example.firsova.comparator;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.repository.RepositoryArray;
import org.example.firsova.repository.RepositoryArrayImpl;
import org.example.firsova.warehouse.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComparatorTest {
    private final RepositoryArray repository = RepositoryArrayImpl.getInstance();

    @BeforeEach
    void setUp() {
        repository.add(new ArrayInt(3, new int[]{7, 1}));         // sum 8
        repository.add(new ArrayInt(1, new int[]{-2, 4, 4}));     // sum 6
        repository.add(new ArrayInt(4, new int[0]));              // empty
        repository.add(new ArrayInt(2, new int[]{30}));           // sum 30
    }

    @AfterEach
    void tearDown() {
        repository.clear();
        Warehouse.getInstance().clear();
    }

    @Test
    void idComparatorSortsById() {
        assertEquals(List.of(1, 2, 3, 4), sortedIds(new IdComparator()));
    }

    @Test
    void idComparatorReversedSortsByIdDescending() {
        assertEquals(List.of(4, 3, 2, 1), sortedIds(new IdComparator().reversed()));
    }

    @Test
    void lengthComparatorSortsByNumberOfElements() {
        assertEquals(List.of(4, 2, 3, 1), sortedIds(new LengthComparator()));
    }

    @Test
    void firstElementComparatorPutsEmptyArrayFirst() {
        assertEquals(List.of(4, 1, 3, 2), sortedIds(new FirstElementComparator()));
    }

    @Test
    void sumComparatorSortsBySumFromWarehouse() {
        assertEquals(List.of(4, 1, 3, 2), sortedIds(new SumComparator()));
    }

    @Test
    void comparatorsCanBeCombined() {
        repository.add(new ArrayInt(5, new int[]{0, 0}));

        assertEquals(List.of(4, 2, 3, 5, 1),
                sortedIds(new LengthComparator().thenComparing(new IdComparator())));
    }

    @Test
    void comparatorDoesNotOverflowOnExtremeValues() {
        ArrayInt min = new ArrayInt(10, new int[]{Integer.MIN_VALUE});
        ArrayInt max = new ArrayInt(11, new int[]{Integer.MAX_VALUE});

        assertTrue(new FirstElementComparator().compare(min, max) < 0);
        assertTrue(new FirstElementComparator().compare(max, min) > 0);
    }

    private List<Integer> sortedIds(Comparator<ArrayInt> comparator) {
        return repository.sort(comparator).stream()
                .map(ArrayInt::getArrayId)
                .toList();
    }
}
