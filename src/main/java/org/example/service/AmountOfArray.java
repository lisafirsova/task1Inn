package org.example.service;

import org.example.entity.ArrayInt;

import java.util.Optional;

public class AmountOfArray implements AmountOfArrayInterface {
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
