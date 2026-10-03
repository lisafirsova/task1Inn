package org.example.read;

import org.example.exception.ArrayException;

import java.util.List;

public interface ArrayReaderInterface {
    public List<String> readLinesForArray() throws ArrayException;
}
