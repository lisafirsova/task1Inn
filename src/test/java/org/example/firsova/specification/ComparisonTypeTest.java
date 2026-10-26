package org.example.firsova.specification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComparisonTypeTest {
    @Test
    void greaterIsTrueOnlyWhenActualIsBigger() {
        assertTrue(ComparisonType.GREATER.compare(5, 3));
        assertFalse(ComparisonType.GREATER.compare(3, 3));
        assertFalse(ComparisonType.GREATER.compare(1, 3));
    }

    @Test
    void lessIsTrueOnlyWhenActualIsSmaller() {
        assertTrue(ComparisonType.LESS.compare(1, 3));
        assertFalse(ComparisonType.LESS.compare(3, 3));
        assertFalse(ComparisonType.LESS.compare(5, 3));
    }

    @Test
    void equalIsTrueOnlyWhenValuesAreSame() {
        assertTrue(ComparisonType.EQUAL.compare(2.5, 2.5));
        assertFalse(ComparisonType.EQUAL.compare(2.5, 2.4));
    }
}
