package org.example.firsova.service.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.service.SearchForMinAndMax;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchForMinAndMaxImplTest {
    private final SearchForMinAndMax service = new SearchForMinAndMaxImpl();
    private final ArrayInt array = new ArrayInt(1, new int[]{4, -7, 12, 0, 12});
    private final ArrayInt emptyArray = new ArrayInt(2, new int[0]);

    @Test
    void findMinReturnsSmallestElement() {
        assertEquals(OptionalInt.of(-7), service.findMin(array));
    }

    @Test
    void findMaxReturnsLargestElement() {
        assertEquals(OptionalInt.of(12), service.findMax(array));
    }

    @Test
    void singleElementIsBothMinAndMax() {
        ArrayInt single = new ArrayInt(3, new int[]{5});

        assertEquals(OptionalInt.of(5), service.findMin(single));
        assertEquals(OptionalInt.of(5), service.findMax(single));
    }

    @Test
    void emptyArrayHasNoMinAndMax() {
        assertTrue(service.findMin(emptyArray).isEmpty());
        assertTrue(service.findMax(emptyArray).isEmpty());
    }
}
