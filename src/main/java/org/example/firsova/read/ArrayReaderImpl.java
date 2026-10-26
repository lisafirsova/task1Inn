package org.example.firsova.read;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.firsova.exception.ArrayException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    private static final Logger LOGGER = LogManager.getLogger(ArrayReaderImpl.class);

    @Override
    public List<String> readLines(String path) throws ArrayException {
        if (path == null) {
            throw new ArrayException("Path is null.");
        }
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            LOGGER.info("Read {} lines from file {}", lines.size(), path);
            return lines;
        } catch (IOException e) {
            throw new ArrayException("Cannot read file: " + path, e);
        }
    }
}
