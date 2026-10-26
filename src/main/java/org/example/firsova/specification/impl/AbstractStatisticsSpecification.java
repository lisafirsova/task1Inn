package org.example.firsova.specification.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.entity.ArrayStatistics;
import org.example.firsova.specification.ArraySpecification;
import org.example.firsova.specification.ComparisonType;
import org.example.firsova.warehouse.Warehouse;

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
