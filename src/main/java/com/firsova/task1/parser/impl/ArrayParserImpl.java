package com.firsova.task1.parser.impl;

import com.firsova.task1.exception.ArrayException;
import com.firsova.task1.parser.ArrayParser;

public class ArrayParserImpl implements ArrayParser {
    public static final String DELIMITER_REGEX = "[,;\\s]+";

    @Override
    public int[] parseArray(String line) throws ArrayException {
        if (line == null) {
            throw new ArrayException("Line is null.");
        }
        String trimmed = line.strip();
        if (trimmed.isEmpty()) {
            return new int[0];
        }
        String[] tokens = trimmed.split(DELIMITER_REGEX);
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; ++i) {
            try {
                numbers[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                throw new ArrayException("Invalid number: " + tokens[i], e);
            }
        }
        return numbers;
    }
}
