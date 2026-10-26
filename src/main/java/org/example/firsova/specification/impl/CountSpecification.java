package org.example.firsova.specification.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.specification.ArraySpecification;
import org.example.firsova.specification.ComparisonType;

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
