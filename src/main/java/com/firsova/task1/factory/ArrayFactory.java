package com.firsova.task1.factory;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.exception.ArrayException;

public interface ArrayFactory {
    ArrayInt create(int[] numbers) throws ArrayException;
}
