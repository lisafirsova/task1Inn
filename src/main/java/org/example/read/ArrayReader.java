package org.example.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.example.exception.ArrayException;

public class ArrayReader implements ArrayReaderInterface {
    @Override
    public List<String> readLinesForArray() throws ArrayException {
        Path path = Path.of("data/array.txt");
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new ArrayException("Cannot read file.");
        }
    }
}
