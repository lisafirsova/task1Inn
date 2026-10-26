package org.example.firsova.factory;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.exception.ArrayException;

public interface ArrayFactory {
    ArrayInt create(int[] numbers) throws ArrayException;
}
