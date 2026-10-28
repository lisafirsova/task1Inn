package com.firsova.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.firsova.task1.comparator.FirstElementComparator;
import com.firsova.task1.comparator.IdComparator;
import com.firsova.task1.comparator.LengthComparator;
import com.firsova.task1.comparator.SumComparator;
import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.exception.ArrayException;
import com.firsova.task1.factory.ArrayFactory;
import com.firsova.task1.factory.impl.ArrayFactoryImpl;
import com.firsova.task1.parser.ArrayParser;
import com.firsova.task1.parser.impl.ArrayParserImpl;
import com.firsova.task1.reader.ArrayReader;
import com.firsova.task1.reader.impl.ArrayReaderImpl;
import com.firsova.task1.repository.ArrayRepository;
import com.firsova.task1.repository.impl.ArrayRepositoryImpl;
import com.firsova.task1.service.ArraySortService;
import com.firsova.task1.service.impl.ArraySortServiceImpl;
import com.firsova.task1.specification.ComparisonType;
import com.firsova.task1.specification.impl.AverageSpecification;
import com.firsova.task1.specification.impl.CountSpecification;
import com.firsova.task1.specification.impl.IdSpecification;
import com.firsova.task1.specification.impl.MaxSpecification;
import com.firsova.task1.specification.impl.MinSpecification;
import com.firsova.task1.specification.impl.SumSpecification;
import com.firsova.task1.validator.ArrayValidator;
import com.firsova.task1.validator.impl.ArrayValidatorImpl;
import com.firsova.task1.warehouse.Warehouse;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String FILE_PATH = "data/array.txt";

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReaderImpl();
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new ArrayFactoryImpl();
        ArrayRepository repository = ArrayRepositoryImpl.getInstance();
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

        ArraySortService sortService = new ArraySortServiceImpl();
        for (ArrayInt array : repository.sort(new IdComparator())) {
            LOGGER.info("id={} bubble={} quick={}", array.getArrayId(),
                    Arrays.toString(sortService.bubbleSort(array)),
                    Arrays.toString(sortService.quickSort(array)));
        }
    }
}
