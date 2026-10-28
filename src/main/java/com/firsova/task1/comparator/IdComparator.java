package com.firsova.task1.comparator;

import com.firsova.task1.entity.ArrayInt;

import java.util.Comparator;

public class IdComparator implements Comparator<ArrayInt> {
    @Override
    public int compare(ArrayInt first, ArrayInt second) {
        return Integer.compare(first.getArrayId(), second.getArrayId());
    }
}
