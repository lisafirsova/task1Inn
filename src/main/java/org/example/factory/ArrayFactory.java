package org.example.factory;

import org.example.entity.ArrayInt;
import org.example.exception.ArrayException;

public interface ArrayFactory {
    ArrayInt create(int id, int[] numbers) throws ArrayException;
}
