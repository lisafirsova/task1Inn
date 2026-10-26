package org.example.firsova.comparator;

import org.example.firsova.entity.ArrayInt;

import java.util.Comparator;

public class LengthComparator implements Comparator<ArrayInt> {
    @Override
    public int compare(ArrayInt first, ArrayInt second) {
        return Integer.compare(first.getLength(), second.getLength());
    }
}
