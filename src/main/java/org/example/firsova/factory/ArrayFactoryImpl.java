package org.example.firsova.factory;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.exception.ArrayException;

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
