package org.example.parse;

import org.example.exception.ArrayException;

public interface Parser {
    int[] parseArray(String s) throws ArrayException;
}
