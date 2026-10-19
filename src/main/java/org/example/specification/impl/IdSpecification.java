package org.example.specification.impl;

import org.example.entity.ArrayInt;
import org.example.specification.ArraySpecification;

public class IdSpecification implements ArraySpecification {
    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean matches(ArrayInt array) {
        long arrayId = array.getArrayId();
        return arrayId == id;
    }
}
