package org.example.firsova.service.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.service.AmountOfArray;

import java.util.OptionalLong;

public class AmountOfArrayImpl implements AmountOfArray {
    @Override
    public OptionalLong amountOf(ArrayInt arrayInt) {
        int[] array = arrayInt.getArray();
        if (array.length == 0) {
            return OptionalLong.empty();
        }
        long sum = 0;
        for (int element : array) {
            sum += element;
        }
        return OptionalLong.of(sum);
    }
}
