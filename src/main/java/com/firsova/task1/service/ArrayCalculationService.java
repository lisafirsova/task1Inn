package com.firsova.task1.service;

import com.firsova.task1.entity.ArrayInt;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface ArrayCalculationService {
    OptionalLong calculateSum(ArrayInt array);

    OptionalDouble calculateAverage(ArrayInt array);

    OptionalInt findMin(ArrayInt array);

    OptionalInt findMax(ArrayInt array);
}
