package org.example.service;

import org.example.entity.ArrayInt;

import java.util.Optional;

public class SearchForMinAndMax implements SearchForMinAndMaxInterface {
    @Override
    public Optional<Integer> findMin(ArrayInt arrInt) {
        int[] array = arrInt.getArray();
        if (array.length == 0) {
            return Optional.empty();
        }
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMax(ArrayInt arrInt) {
        int[] array = arrInt.getArray();
        if (array.length == 0) {
            return Optional.empty();
        }
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return Optional.of(max);
    }
}
