package org.example.validation;

import org.example.exception.ArrayException;

public interface ValidatorInterface {
    public boolean isValid(String s) throws ArrayException;
}
