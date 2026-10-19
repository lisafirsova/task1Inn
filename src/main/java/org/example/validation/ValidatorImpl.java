package org.example.validation;
import org.example.exception.ArrayException;

import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    public static final Pattern PATTERN=Pattern.compile("\\s*(\\d+([,;\\s]+\\d+)*)?\\s*");
    @Override
    public boolean isValid(String s) throws ArrayException {
        return PATTERN.matcher(s).matches();
    }
}
