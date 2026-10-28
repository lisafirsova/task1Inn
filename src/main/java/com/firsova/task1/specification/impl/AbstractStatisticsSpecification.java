package com.firsova.task1.specification.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.entity.ArrayStatistics;
import com.firsova.task1.specification.ArraySpecification;
import com.firsova.task1.specification.ComparisonType;
import com.firsova.task1.warehouse.Warehouse;

import java.util.Optional;

public abstract class AbstractStatisticsSpecification implements ArraySpecification {
    private final ComparisonType comparisonType;
    private final double value;

    protected AbstractStatisticsSpecification(ComparisonType comparisonType, double value) {
        this.comparisonType = comparisonType;
        this.value = value;
    }

    @Override
    public boolean matches(ArrayInt array) {
        Optional<ArrayStatistics> statistics = Warehouse.getInstance().find(array.getArrayId());
        if (statistics.isEmpty()) {
            return false;
        }
        double actual = extractValue(statistics.get());
        return comparisonType.compare(actual, value);
    }

    protected abstract double extractValue(ArrayStatistics statistics);
}
