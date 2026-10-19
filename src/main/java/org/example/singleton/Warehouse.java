package org.example.singleton;

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

    public Optional<ArrayStatistics> find(long id) {
        ArrayStatistics statistics = storage.get(id);
        return Optional.ofNullable(statistics);
    }

    public void clear() {
        storage.clear();
    }
}
