package org.example.firsova.parse;

import org.example.firsova.exception.ArrayException;

public interface Parser {
    int[] parseArray(String line) throws ArrayException;
}
