package com.firsova.task1.specification.impl;

import com.firsova.task1.entity.ArrayStatistics;
import com.firsova.task1.specification.ComparisonType;

public class MaxSpecification extends AbstractStatisticsSpecification {
    public MaxSpecification(ComparisonType comparisonType, double value) {
        super(comparisonType, value);
    }

    @Override
    protected double extractValue(ArrayStatistics statistics) {
        return statistics.getMax();
    }
}
