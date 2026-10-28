package com.firsova.task1.reader;

import com.firsova.task1.exception.ArrayException;

import java.util.List;

public interface ArrayReader {
    List<String> readLines(String path) throws ArrayException;
}
