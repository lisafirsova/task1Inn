package org.example.singleton;
import java.util.Optional;

public class ArrayStatistics {
    private final Optional<Long> sum;
    private final Optional<Double> average;
    private final Optional<Integer> max;
    private final Optional<Integer> min;

    public ArrayStatistics(Optional<Long> sum, Optional<Double> average, Optional<Integer> max, Optional<Integer> min) {
        this.sum = sum;
        this.average = average;
        this.max = max;
        this.min = min;
    }

    public Optional<Long> getSum() {
        return sum;
    }

    public Optional<Double> getAverage() {
        return average;
    }

    public Optional<Integer> getMax() {
        return max;
    }

    public Optional<Integer> getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "ArrayStatistics{sum=" + sum + ", average=" + average + ", max=" + max + ", min=" + min + "}";
    }
}