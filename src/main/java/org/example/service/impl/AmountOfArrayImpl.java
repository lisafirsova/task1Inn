package org.example.service.impl;

import org.example.entity.ArrayInt;
import org.example.service.AmountOfArray;

import java.util.Optional;

public class AmountOfArrayImpl implements AmountOfArray {
    @Override
    public Optional<Integer> amountOf(ArrayInt arrInt) {
        int[] array = arrInt.getArray();
        if (array.length == 0) {
            return Optional.empty();
        }
        int amountOfArray = 0;
        for (int element : array) {
            amountOfArray += element;
        }
        return Optional.of(amountOfArray);
    }
}
