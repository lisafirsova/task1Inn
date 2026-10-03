package org.example.parse;

import org.example.exception.ArrayException;

public interface ParserInterface {
    public int[] parseArray(String s) throws ArrayException;
}
