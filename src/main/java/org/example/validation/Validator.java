package org.example.validation;

import org.example.exception.ArrayException;

public interface Validator {
    boolean isValid(String s) throws ArrayException;
}
