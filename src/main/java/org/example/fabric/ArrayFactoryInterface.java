package org.example.fabric;

import org.example.entity.ArrayInt;
import org.example.exception.ArrayException;

public interface ArrayFactoryInterface {
    public ArrayInt create(int[] numbers) throws ArrayException;
}
