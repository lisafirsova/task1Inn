package org.example.firsova.observer;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.entity.ArrayStatistics;
import org.example.firsova.exception.ArrayException;
import org.example.firsova.repository.RepositoryArray;
import org.example.firsova.repository.RepositoryArrayImpl;
import org.example.firsova.warehouse.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayObserverImplTest {
    private static final double DELTA = 1e-9;

    private final ArrayObserver observer = new ArrayObserverImpl();
    private final Warehouse warehouse = Warehouse.getInstance();
    private final RepositoryArray repository = RepositoryArrayImpl.getInstance();

    @AfterEach
    void tearDown() {
        repository.clear();
        warehouse.clear();
    }

    @Test
    void updatePutsStatisticsIntoWarehouse() {
        ArrayInt array = new ArrayInt(1, new int[]{4, -2, 7});

        observer.update(array);

        ArrayStatistics statistics = warehouse.find(1).orElseThrow();
        assertEquals(-2, statistics.getMin());
        assertEquals(7, statistics.getMax());
        assertEquals(9, statistics.getSum());
        assertEquals(3.0, statistics.getAverage(), DELTA);
    }

    @Test
    void updateOfEmptyArrayRemovesStatistics() {
        observer.update(new ArrayInt(1, new int[]{1, 2}));

        observer.update(new ArrayInt(1, new int[0]));

        assertTrue(warehouse.find(1).isEmpty());
    }

    @Test
    void deleteRemovesStatisticsFromWarehouse() {
        ArrayInt array = new ArrayInt(1, new int[]{1, 2});
        observer.update(array);

        observer.delete(array);

        assertTrue(warehouse.find(1).isEmpty());
    }

    @Test
    void attachedObserverRecalculatesStatisticsOnElementChange() throws ArrayException {
        ArrayInt array = new ArrayInt(1, new int[]{1, 2, 3});
        array.attach(observer);

        array.setElement(1, 20);

        ArrayStatistics statistics = warehouse.find(1).orElseThrow();
        assertEquals(1, statistics.getMin());
        assertEquals(20, statistics.getMax());
        assertEquals(24, statistics.getSum());
        assertEquals(8.0, statistics.getAverage(), DELTA);
    }

    @Test
    void detachedObserverIsNotNotified() throws ArrayException {
        ArrayInt array = new ArrayInt(1, new int[]{1, 2, 3});
        array.attach(observer);
        array.detach(observer);

        array.setElement(0, 50);

        assertTrue(warehouse.find(1).isEmpty());
    }

    @Test
    void repositoryKeepsWarehouseInSync() throws ArrayException {
        ArrayInt array = new ArrayInt(1, new int[]{5, 5});

        repository.add(array);
        assertEquals(10, warehouse.find(1).orElseThrow().getSum());

        array.setElement(0, 15);
        assertEquals(20, warehouse.find(1).orElseThrow().getSum());

        repository.remove(1);
        assertTrue(warehouse.find(1).isEmpty());
    }

    @Test
    void setElementWithWrongIndexThrowsException() {
        ArrayInt array = new ArrayInt(1, new int[]{1, 2});

        assertThrows(ArrayException.class, () -> array.setElement(2, 0));
        assertThrows(ArrayException.class, () -> array.setElement(-1, 0));
    }
}
