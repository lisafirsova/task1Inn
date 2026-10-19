package org.example.read;

import org.example.exception.ArrayException;

import java.util.List;

public interface ArrayReader {
    List<String> readLinesForArray() throws ArrayException;
}
