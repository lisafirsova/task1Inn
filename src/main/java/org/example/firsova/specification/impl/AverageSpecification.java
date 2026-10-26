package org.example.firsova.specification.impl;

import org.example.firsova.entity.ArrayStatistics;
import org.example.firsova.specification.ComparisonType;

public class AverageSpecification extends AbstractStatisticsSpecification {
    public AverageSpecification(ComparisonType comparisonType, double value) {
        super(comparisonType, value);
    }

    @Override
    protected double extractValue(ArrayStatistics statistics) {
        return statistics.getAverage();
    }
}
