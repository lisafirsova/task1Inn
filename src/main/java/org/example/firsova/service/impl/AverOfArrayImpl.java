package org.example.firsova.service.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.service.AmountOfArray;
import org.example.firsova.service.AverOfArray;

import java.util.OptionalDouble;
import java.util.OptionalLong;

public class AverOfArrayImpl implements AverOfArray {
    private final AmountOfArray amountService = new AmountOfArrayImpl();

    @Override
    public OptionalDouble aver(ArrayInt arrayInt) {
        OptionalLong sum = amountService.amountOf(arrayInt);
        if (sum.isEmpty()) {
            return OptionalDouble.empty();
        }
        double average = (double) sum.getAsLong() / arrayInt.getLength();
        return OptionalDouble.of(average);
    }
}
