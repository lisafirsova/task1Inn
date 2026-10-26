package org.example.firsova.specification;

public enum ComparisonType {
    GREATER,
    LESS,
    EQUAL;

    public boolean compare(double actual, double expected) {
        int result = Double.compare(actual, expected);
        return switch (this) {
            case GREATER -> result > 0;
            case LESS -> result < 0;
            case EQUAL -> result == 0;
        };
    }
}
