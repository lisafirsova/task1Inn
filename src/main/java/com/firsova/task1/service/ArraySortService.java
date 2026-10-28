package com.firsova.task1.service;

import com.firsova.task1.entity.ArrayInt;

public interface ArraySortService {
    int[] bubbleSort(ArrayInt array);

    int[] quickSort(ArrayInt array);
}
