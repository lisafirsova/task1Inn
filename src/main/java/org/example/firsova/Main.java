package org.example.firsova;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.firsova.comparator.FirstElementComparator;
import org.example.firsova.comparator.IdComparator;
import org.example.firsova.comparator.LengthComparator;
import org.example.firsova.comparator.SumComparator;
import org.example.firsova.entity.ArrayInt;
import org.example.firsova.exception.ArrayException;
import org.example.firsova.factory.ArrayFactory;
import org.example.firsova.factory.ArrayFactoryImpl;
import org.example.firsova.parse.Parser;
import org.example.firsova.parse.ParserImpl;
import org.example.firsova.read.ArrayReader;
import org.example.firsova.read.ArrayReaderImpl;
import org.example.firsova.repository.RepositoryArray;
import org.example.firsova.repository.RepositoryArrayImpl;
import org.example.firsova.service.SortingAlgorithms;
import org.example.firsova.service.impl.SortingAlgorithmsImpl;
import org.example.firsova.specification.ComparisonType;
import org.example.firsova.specification.impl.AverageSpecification;
import org.example.firsova.specification.impl.CountSpecification;
import org.example.firsova.specification.impl.IdSpecification;
import org.example.firsova.specification.impl.MaxSpecification;
import org.example.firsova.specification.impl.MinSpecification;
import org.example.firsova.specification.impl.SumSpecification;
import org.example.firsova.validation.Validator;
import org.example.firsova.validation.ValidatorImpl;
import org.example.firsova.warehouse.Warehouse;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String FILE_PATH = "data/array.txt";

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReaderImpl();
        Validator validator = new ValidatorImpl();
        Parser parser = new ParserImpl();
        ArrayFactory factory = new ArrayFactoryImpl();
        RepositoryArray repository = RepositoryArrayImpl.getInstance();
        Warehouse warehouse = Warehouse.getInstance();

        List<String> lines;
        try {
            lines = reader.readLines(FILE_PATH);
        } catch (ArrayException e) {
            LOGGER.error("Cannot load arrays", e);
            return;
        }

        for (String line : lines) {
            if (!validator.isValid(line)) {
                LOGGER.warn("Invalid line skipped: '{}'", line);
                continue;
            }
            try {
                ArrayInt array = factory.create(parser.parseArray(line));
                repository.add(array);
            } catch (ArrayException e) {
                LOGGER.warn("Line skipped: '{}', reason: {}", line, e.getMessage());
            }
        }

        List<ArrayInt> found = repository.findBy(new IdSpecification(1));
        if (!found.isEmpty()) {
            ArrayInt first = found.get(0);
            try {
                first.setElement(0, 100);
            } catch (ArrayException e) {
                LOGGER.error("Cannot change element", e);
            }
            LOGGER.info("After change: {} -> {}", first, warehouse.find(first.getArrayId()));
        }

        LOGGER.info("Sum > 20: {}", repository.findBy(new SumSpecification(ComparisonType.GREATER, 20)));
        LOGGER.info("Average < 5: {}", repository.findBy(new AverageSpecification(ComparisonType.LESS, 5)));
        LOGGER.info("Max = 7: {}", repository.findBy(new MaxSpecification(ComparisonType.EQUAL, 7)));
        LOGGER.info("Min < 0: {}", repository.findBy(new MinSpecification(ComparisonType.LESS, 0)));
        LOGGER.info("Count > 3: {}", repository.findBy(new CountSpecification(ComparisonType.GREATER, 3)));

        LOGGER.info("Sorted by id desc: {}", repository.sort(new IdComparator().reversed()));
        LOGGER.info("Sorted by first element: {}", repository.sort(new FirstElementComparator()));
        LOGGER.info("Sorted by length, then id: {}",
                repository.sort(new LengthComparator().thenComparing(new IdComparator())));
        LOGGER.info("Sorted by sum: {}", repository.sort(new SumComparator()));

        if (repository.remove(5)) {
            LOGGER.info("Array id=5 removed, statistics: {}", warehouse.find(5));
        }

        SortingAlgorithms sortService = new SortingAlgorithmsImpl();
        for (ArrayInt array : repository.sort(new IdComparator())) {
            LOGGER.info("id={} bubble={} quick={}", array.getArrayId(),
                    Arrays.toString(sortService.bubbleSort(array)),
                    Arrays.toString(sortService.quickSort(array)));
        }
    }
}
