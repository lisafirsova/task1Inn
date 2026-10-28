package com.firsova.task1.repository.impl;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.observer.ArrayObserver;
import com.firsova.task1.observer.impl.ArrayObserverImpl;
import com.firsova.task1.repository.ArrayRepository;
import com.firsova.task1.specification.ArraySpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static ArrayRepositoryImpl instance;

    private final Set<ArrayInt> arrays = new HashSet<>();
    private final ArrayObserver observer = new ArrayObserverImpl();

    private ArrayRepositoryImpl() {
    }

    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public boolean add(ArrayInt array) {
        if (!arrays.add(array)) {
            return false;
        }
        array.attach(observer);
        observer.update(array);
        return true;
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
        Iterator<ArrayInt> iterator = arrays.iterator();
        while (iterator.hasNext()) {
            ArrayInt array = iterator.next();
            if (array.getArrayId() == id) {
                iterator.remove();
                release(array);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ArrayInt> sort(Comparator<ArrayInt> comparator) {
        List<ArrayInt> result = new ArrayList<>(arrays);
        result.sort(comparator);
        return result;
    }

    @Override
    public void clear() {
        for (ArrayInt array : arrays) {
            release(array);
        }
        arrays.clear();
    }

    private void release(ArrayInt array) {
        observer.delete(array);
        array.detach(observer);
    }
}
