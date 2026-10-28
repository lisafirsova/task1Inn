package com.firsova.task1.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.entity.ArrayStatistics;
import com.firsova.task1.observer.ArrayObserver;
import com.firsova.task1.service.ArrayCalculationService;
import com.firsova.task1.service.impl.ArrayCalculationServiceImpl;
import com.firsova.task1.warehouse.Warehouse;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger LOGGER = LogManager.getLogger(ArrayObserverImpl.class);

    private final ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();

    @Override
    public void update(ArrayInt array) {
        Warehouse warehouse = Warehouse.getInstance();
        int id = array.getArrayId();
        if (array.getLength() == 0) {
            warehouse.remove(id);
            LOGGER.info("Array id={} is empty, no statistics stored", id);
            return;
        }
        ArrayStatistics statistics = new ArrayStatistics(
                calculationService.findMin(array).orElseThrow(),
                calculationService.findMax(array).orElseThrow(),
                calculationService.calculateSum(array).orElseThrow(),
                calculationService.calculateAverage(array).orElseThrow()
        );
        warehouse.put(id, statistics);
        LOGGER.info("Warehouse updated for array id={}: {}", id, statistics);
    }

    @Override
    public void delete(ArrayInt array) {
        Warehouse.getInstance().remove(array.getArrayId());
        LOGGER.info("Warehouse removed statistics for array id={}", array.getArrayId());
    }
}
