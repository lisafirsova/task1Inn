package org.example.firsova.service.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.service.SearchForMinAndMax;

import java.util.OptionalInt;

public class SearchForMinAndMaxImpl implements SearchForMinAndMax {
    @Override
    public OptionalInt findMin(ArrayInt arrayInt) {
        int[] array = arrayInt.getArray();
        if (array.length == 0) {
            return OptionalInt.empty();
        }
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt findMax(ArrayInt arrayInt) {
        int[] array = arrayInt.getArray();
        if (array.length == 0) {
            return OptionalInt.empty();
        }
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return OptionalInt.of(max);
    }
}
