package org.example.firsova.validation;

import org.example.firsova.parse.ParserImpl;

import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String NUMBER_REGEX = "-?\\d+";
    private static final Pattern ARRAY_LINE_PATTERN = Pattern.compile(
            "\\s*(" + NUMBER_REGEX + "(" + ParserImpl.DELIMITER_REGEX + NUMBER_REGEX + ")*)?\\s*");

    @Override
    public boolean isValid(String line) {
        if (line == null) {
            return false;
        }
        return ARRAY_LINE_PATTERN.matcher(line).matches();
    }
}
