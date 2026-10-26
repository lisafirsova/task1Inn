package org.example.firsova.read;

import org.example.firsova.exception.ArrayException;

import java.util.List;

public interface ArrayReader {
    List<String> readLines(String path) throws ArrayException;
}
