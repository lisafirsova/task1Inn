package org.example.firsova.observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.firsova.entity.ArrayInt;
import org.example.firsova.entity.ArrayStatistics;
import org.example.firsova.service.AmountOfArray;
import org.example.firsova.service.AverOfArray;
import org.example.firsova.service.SearchForMinAndMax;
import org.example.firsova.service.impl.AmountOfArrayImpl;
import org.example.firsova.service.impl.AverOfArrayImpl;
import org.example.firsova.service.impl.SearchForMinAndMaxImpl;
import org.example.firsova.warehouse.Warehouse;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger LOGGER = LogManager.getLogger(ArrayObserverImpl.class);

    private final AmountOfArray amountService = new AmountOfArrayImpl();
    private final AverOfArray averageService = new AverOfArrayImpl();
    private final SearchForMinAndMax minMaxService = new SearchForMinAndMaxImpl();

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
                minMaxService.findMin(array).orElseThrow(),
                minMaxService.findMax(array).orElseThrow(),
                amountService.amountOf(array).orElseThrow(),
                averageService.aver(array).orElseThrow()
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
