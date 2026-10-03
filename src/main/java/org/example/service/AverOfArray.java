package org.example.service;

import org.example.entity.ArrayInt;
import org.example.service.AmountOfArray;

import java.util.Optional;

public class AverOfArray implements AverOfArrayInterface {
    @Override
    public Optional<Integer> aver(ArrayInt arrayInt) {
        int[] array = arrayInt.getArray();
        int count = array.length;
        if (count == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        int averArr = sum / count;
        return Optional.of(averArr);
    }
}
