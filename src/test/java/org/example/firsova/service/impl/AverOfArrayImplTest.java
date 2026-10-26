package org.example.firsova.service.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.service.AverOfArray;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AverOfArrayImplTest {
    private static final double DELTA = 1e-9;

    private final AverOfArray service = new AverOfArrayImpl();

    @Test
    void averReturnsFractionalAverage() {
        ArrayInt array = new ArrayInt(1, new int[]{1, 2});

        double actual = service.aver(array).orElseThrow();

        assertEquals(1.5, actual, DELTA);
    }

    @Test
    void averWorksWithNegativeNumbers() {
        ArrayInt array = new ArrayInt(1, new int[]{-5, 3});

        double actual = service.aver(array).orElseThrow();

        assertEquals(-1.0, actual, DELTA);
    }

    @Test
    void averDoesNotOverflow() {
        ArrayInt array = new ArrayInt(1, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});

        double actual = service.aver(array).orElseThrow();

        assertEquals(Integer.MAX_VALUE, actual, DELTA);
    }

    @Test
    void averOfEmptyArrayIsEmpty() {
        ArrayInt array = new ArrayInt(1, new int[0]);

        OptionalDouble actual = service.aver(array);

        assertTrue(actual.isEmpty());
    }
}
