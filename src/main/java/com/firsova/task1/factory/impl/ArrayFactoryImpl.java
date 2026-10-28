package com.firsova.task1.factory.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.exception.ArrayException;
import com.firsova.task1.factory.ArrayFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class ArrayFactoryImpl implements ArrayFactory {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger();

    @Override
    public ArrayInt create(int[] numbers) throws ArrayException {
        if (numbers == null) {
            throw new ArrayException("Numbers are null.");
        }
        return new ArrayInt(ID_COUNTER.incrementAndGet(), numbers);
    }
}
