package com.firsova.task1.specification.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.specification.ArraySpecification;
import com.firsova.task1.specification.ComparisonType;

public class CountSpecification implements ArraySpecification {
    private final ComparisonType comparisonType;
    private final int count;

    public CountSpecification(ComparisonType comparisonType, int count) {
        this.comparisonType = comparisonType;
        this.count = count;
    }

    @Override
    public boolean matches(ArrayInt array) {
        return comparisonType.compare(array.getLength(), count);
    }
}
