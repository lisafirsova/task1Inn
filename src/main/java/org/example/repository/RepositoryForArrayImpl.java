package org.example.repository;

import org.example.entity.ArrayInt;
import org.example.singleton.Warehouse;
import org.example.specification.ArraySpecification;
import org.example.specification.impl.IdSpecification;

import java.util.*;

public class RepositoryForArrayImpl implements RepositoryForArray {
    private static RepositoryForArrayImpl instance;
    private final Set<ArrayInt> arrays = new HashSet<>();

    private RepositoryForArrayImpl() {
    }

    public static RepositoryForArrayImpl getInstance() {
        if (instance == null) {
            instance = new RepositoryForArrayImpl();
        }
        return instance;
    }

    @Override
    public boolean addElement(ArrayInt array) {
        return arrays.add(array);
    }

    @Override
    public List<ArrayInt> findBy(ArraySpecification specification) {
        List<ArrayInt> result = new ArrayList<>();
        for (ArrayInt array : arrays) {
            if (specification.matches(array)) {
                result.add(array);
            }
        }
        return result;
    }

    @Override
    public boolean remove(int id) {
        IdSpecification specification = new IdSpecification(id);
        List<ArrayInt> found = findBy(specification);
        if (found.isEmpty()) {
            return false;
        }
        ArrayInt array = found.get(0);
        arrays.remove(array);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.remove(id);
        return true;
    }

    @Override
    public List<ArrayInt> sort(Comparator<ArrayInt> comparator) {
        List<ArrayInt> result = new ArrayList<>(arrays);
        result.sort(comparator);
        return result;
    }

    @Override
    public void clear() {
        Warehouse warehouse = Warehouse.getInstance();
        for (ArrayInt array : arrays) {
            int id = array.getArrayId();
            warehouse.remove(id);
        }
        arrays.clear();
    }
}
