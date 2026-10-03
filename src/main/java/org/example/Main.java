package org.example;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.ArrayInt;
import org.example.exception.ArrayException;
import org.example.fabric.ArrayFactory;
import org.example.parse.Parser;
import org.example.read.ArrayReader;
import org.example.service.SortingAlgorithms;
import org.example.validation.Validator;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    void main() throws ArrayException {
        ArrayReader reader = new ArrayReader();
        Validator validator = new Validator();
        Parser parser = new Parser();
        ArrayFactory factory = new ArrayFactory();
        SortingAlgorithms sortService = new SortingAlgorithms();
        List<String> lines = reader.readLinesForArray();
        for (String line : lines) {
            if (validator.isValid(line)) {
                int[] numbers = parser.parseArray(line);
                ArrayInt array = factory.create(numbers);
                ArrayInt sorted = sortService.quickSort(array);
                LOGGER.info("Sorted: {}", sorted);
            } else {
                LOGGER.warn("Line rejected: '{}'", line);
            }
        }
    }
}