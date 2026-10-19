package org.example;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.ArrayInt;
import org.example.exception.ArrayException;
import org.example.factory.ArrayFactoryImpl;
import org.example.parse.ParserImpl;
import org.example.read.ArrayReaderImpl;
import org.example.service.impl.SortingAlgorithmsImpl;
import org.example.validation.ValidatorImpl;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    void main() throws ArrayException {
        ArrayReaderImpl reader = new ArrayReaderImpl();
        ValidatorImpl validatorImpl = new ValidatorImpl();
        ParserImpl parserImpl = new ParserImpl();
        ArrayFactoryImpl factory = new ArrayFactoryImpl();
        SortingAlgorithmsImpl sortService = new SortingAlgorithmsImpl();
        List<String> lines = reader.readLinesForArray();
    }
}