package com.firsova.task1.validator.impl;

import com.firsova.task1.parser.impl.ArrayParserImpl;
import com.firsova.task1.validator.ArrayValidator;

import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final String NUMBER_REGEX = "-?\\d+";
    private static final Pattern ARRAY_LINE_PATTERN = Pattern.compile(
            "\\s*(" + NUMBER_REGEX + "(" + ArrayParserImpl.DELIMITER_REGEX + NUMBER_REGEX + ")*)?\\s*");

    @Override
    public boolean isValid(String stringOfNumbers) {
        if (stringOfNumbers == null) {
            return false;
        }
        return ARRAY_LINE_PATTERN.matcher(stringOfNumbers).matches();
    }
}
