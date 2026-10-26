package org.example.firsova.service;

import org.example.firsova.entity.ArrayInt;

import java.util.OptionalInt;

public interface SearchForMinAndMax {
    OptionalInt findMin(ArrayInt array);

    OptionalInt findMax(ArrayInt array);
}
