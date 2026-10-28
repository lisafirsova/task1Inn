package com.firsova.task1.service.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.service.ArrayCalculationService;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayCalculationServiceImplTest {
    private static final double DELTA = 1e-9;

    private final ArrayCalculationService service = new ArrayCalculationServiceImpl();
    private final ArrayInt emptyArray = new ArrayInt(1, new int[0]);

    @Test
    void calculateSumReturnsSumOfElements() {
        ArrayInt array = new ArrayInt(1, new int[]{1, 2, 3, -4});

        OptionalLong actual = service.calculateSum(array);

        assertEquals(OptionalLong.of(2), actual);
    }

    @Test
    void calculateSumDoesNotOverflow() {
        ArrayInt array = new ArrayInt(1, new int[]{Integer.MAX_VALUE, 1});

        OptionalLong actual = service.calculateSum(array);

        assertEquals(OptionalLong.of(2147483648L), actual);
    }

    @Test
    void calculateAverageReturnsFractionalAverage() {
        ArrayInt array = new ArrayInt(1, new int[]{1, 2});

        double actual = service.calculateAverage(array).orElseThrow();

        assertEquals(1.5, actual, DELTA);
    }

    @Test
    void calculateAverageWorksWithNegativeNumbers() {
        ArrayInt array = new ArrayInt(1, new int[]{-5, 3});

        double actual = service.calculateAverage(array).orElseThrow();

        assertEquals(-1.0, actual, DELTA);
    }

    @Test
    void calculateAverageDoesNotOverflow() {
        ArrayInt array = new ArrayInt(1, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});

        double actual = service.calculateAverage(array).orElseThrow();

        assertEquals(Integer.MAX_VALUE, actual, DELTA);
    }

    @Test
    void findMinAndMaxReturnSmallestAndLargestElement() {
        ArrayInt array = new ArrayInt(1, new int[]{4, -7, 12, 0, 12});

        assertEquals(OptionalInt.of(-7), service.findMin(array));
        assertEquals(OptionalInt.of(12), service.findMax(array));
    }

    @Test
    void singleElementIsBothMinAndMax() {
        ArrayInt single = new ArrayInt(1, new int[]{5});

        assertEquals(OptionalInt.of(5), service.findMin(single));
        assertEquals(OptionalInt.of(5), service.findMax(single));
    }

    @Test
    void emptyArrayHasNoStatistics() {
        assertTrue(service.calculateSum(emptyArray).isEmpty());
        assertTrue(service.calculateAverage(emptyArray).isEmpty());
        assertTrue(service.findMin(emptyArray).isEmpty());
        assertTrue(service.findMax(emptyArray).isEmpty());
    }
}
