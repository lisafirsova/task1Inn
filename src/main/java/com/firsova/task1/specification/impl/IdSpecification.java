package com.firsova.task1.specification.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.specification.ArraySpecification;

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
