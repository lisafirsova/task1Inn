package com.firsova.task1.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.firsova.task1.exception.ArrayException;
import com.firsova.task1.reader.ArrayReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    private static final String DEFAULT_FILE_PATH = "data/array.txt";

    @Override
    public List<String> readLines(String path) throws ArrayException {
        String fileName = path;
        if (fileName == null || Files.notExists(Path.of(fileName))) {
            fileName = DEFAULT_FILE_PATH;
        }
        Path filePath = Path.of(fileName);
        try {
            List<String> lines = Files.readAllLines(filePath);
            return lines;
        } catch (IOException e) {
            throw new ArrayException("Cannot read file: " + fileName, e);
        }
    }
}
