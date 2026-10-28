package com.firsova.task1.warehouse;

import com.firsova.task1.entity.ArrayStatistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private static Warehouse instance;

    private final Map<Integer, ArrayStatistics> storage = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void put(int id, ArrayStatistics statistics) {
        storage.put(id, statistics);
    }

    public void remove(int id) {
        storage.remove(id);
    }

    public Optional<ArrayStatistics> find(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void clear() {
        storage.clear();
    }
}
