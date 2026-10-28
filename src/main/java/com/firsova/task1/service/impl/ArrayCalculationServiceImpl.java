package com.firsova.task1.service.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.service.ArrayCalculationService;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    @Override
    public OptionalLong calculateSum(ArrayInt arrayInt) {
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

    @Override
    public OptionalDouble calculateAverage(ArrayInt arrayInt) {
        OptionalLong sum = calculateSum(arrayInt);
        if (sum.isEmpty()) {
            return OptionalDouble.empty();
        }
        double average = (double) sum.getAsLong() / arrayInt.getLength();
        return OptionalDouble.of(average);
    }

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
