package org.example.fabric;

import org.example.entity.ArrayInt;

public class ArrayFactory implements ArrayFactoryInterface {
    @Override
    public ArrayInt create(int[] numbers) {
        return new ArrayInt(numbers);
    }
}
