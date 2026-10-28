package com.firsova.task1.parser;

import com.firsova.task1.exception.ArrayException;

public interface ArrayParser {
    int[] parseArray(String line) throws ArrayException;
}
