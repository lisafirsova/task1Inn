package org.example.firsova.specification.impl;

import org.example.firsova.entity.ArrayStatistics;
import org.example.firsova.specification.ComparisonType;

public class SumSpecification extends AbstractStatisticsSpecification {
    public SumSpecification(ComparisonType comparisonType, double value) {
        super(comparisonType, value);
    }

    @Override
    protected double extractValue(ArrayStatistics statistics) {
        return statistics.getSum();
    }
}
