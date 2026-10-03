package org.example.validation;
import org.example.exception.ArrayException;
import org.example.validation.ValidatorInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements ValidatorInterface {
    public static final Pattern PATTERN=Pattern.compile("\\s*(\\d+([,;\\s]+\\d+)*)?\\s*");
    @Override
    public boolean isValid(String s) throws ArrayException {
        return PATTERN.matcher(s).matches();
    }
}
