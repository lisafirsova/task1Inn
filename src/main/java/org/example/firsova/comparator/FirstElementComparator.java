package org.example.firsova.comparator;

import org.example.firsova.entity.ArrayInt;

import java.util.Comparator;

public class FirstElementComparator implements Comparator<ArrayInt> {
    @Override
    public int compare(ArrayInt first, ArrayInt second) {
        boolean firstEmpty = first.getLength() == 0;
        boolean secondEmpty = second.getLength() == 0;
        if (firstEmpty || secondEmpty) {
            return Boolean.compare(!firstEmpty, !secondEmpty);
        }
        return Integer.compare(first.getArray()[0], second.getArray()[0]);
    }
}
