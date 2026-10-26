package org.example.firsova.specification.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.specification.ArraySpecification;

public class IdSpecification implements ArraySpecification {
    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean matches(ArrayInt array) {
        return array.getArrayId() == id;
    }
}
