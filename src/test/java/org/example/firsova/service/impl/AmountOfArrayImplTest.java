package org.example.firsova.service.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.service.AmountOfArray;
import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AmountOfArrayImplTest {
    private final AmountOfArray service = new AmountOfArrayImpl();

    @Test
    void amountOfReturnsSumOfElements() {
        ArrayInt array = new ArrayInt(1, new int[]{1, 2, 3, -4});

        OptionalLong actual = service.amountOf(array);

        assertEquals(OptionalLong.of(2), actual);
    }

    @Test
    void amountOfDoesNotOverflow() {
        ArrayInt array = new ArrayInt(1, new int[]{Integer.MAX_VALUE, 1});

        OptionalLong actual = service.amountOf(array);

        assertEquals(OptionalLong.of(2147483648L), actual);
    }

    @Test
    void amountOfEmptyArrayIsEmpty() {
        ArrayInt array = new ArrayInt(1, new int[0]);

        OptionalLong actual = service.amountOf(array);

        assertTrue(actual.isEmpty());
    }
}
