package com.firsova.task1.service.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.service.ArraySortService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArraySortServiceImplTest {
    private static final int[] UNSORTED = {9, -3, 5, 0, 5, 1, -10};
    private static final int[] SORTED = {-10, -3, 0, 1, 5, 5, 9};

    private final ArraySortService service = new ArraySortServiceImpl();

    @Test
    void bubbleSortSortsAscending() {
        assertArrayEquals(SORTED, service.bubbleSort(new ArrayInt(1, UNSORTED)));
    }

    @Test
    void quickSortSortsAscending() {
        assertArrayEquals(SORTED, service.quickSort(new ArrayInt(1, UNSORTED)));
    }

    @Test
    void sortingDoesNotChangeSourceArray() {
        ArrayInt array = new ArrayInt(1, UNSORTED);

        service.bubbleSort(array);
        service.quickSort(array);

        assertArrayEquals(UNSORTED, array.getArray());
    }

    @Test
    void sortingHandlesEmptyAndSingleElementArrays() {
        int[] empty = new int[0];
        int[] single = {42};

        assertArrayEquals(empty, service.bubbleSort(new ArrayInt(1, empty)));
        assertArrayEquals(empty, service.quickSort(new ArrayInt(1, empty)));
        assertArrayEquals(single, service.bubbleSort(new ArrayInt(2, single)));
        assertArrayEquals(single, service.quickSort(new ArrayInt(2, single)));
    }

    @Test
    void sortingHandlesAlreadySortedAndReversedArrays() {
        int[] sorted = {1, 2, 3, 4, 5};
        int[] reversed = {5, 4, 3, 2, 1};

        assertArrayEquals(sorted, service.bubbleSort(new ArrayInt(1, sorted)));
        assertArrayEquals(sorted, service.quickSort(new ArrayInt(1, sorted)));
        assertArrayEquals(sorted, service.bubbleSort(new ArrayInt(2, reversed)));
        assertArrayEquals(sorted, service.quickSort(new ArrayInt(2, reversed)));
    }
}
