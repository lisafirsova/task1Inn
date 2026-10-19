package org.example.factory;

import org.example.entity.ArrayInt;

public class ArrayFactoryImpl implements ArrayFactory {
    @Override
    public ArrayInt create(int id, int[] numbers) {
        return new ArrayInt(id, numbers);
    }
}
 