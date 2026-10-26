package org.example.firsova.comparator;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.entity.ArrayStatistics;
import org.example.firsova.warehouse.Warehouse;

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
