package com.firsova.task1.comparator;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.entity.ArrayStatistics;
import com.firsova.task1.warehouse.Warehouse;

import java.util.Comparator;

public class SumComparator implements Comparator<ArrayInt> {
    @Override
    public int compare(ArrayInt first, ArrayInt second) {
        return Long.compare(sumOf(first), sumOf(second));
    }

    private long sumOf(ArrayInt array) {
        return Warehouse.getInstance()
                .find(array.getArrayId())
                .map(ArrayStatistics::getSum)
                .orElse(0L);
    }
}
