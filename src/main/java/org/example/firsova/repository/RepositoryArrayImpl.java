package org.example.firsova.repository;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.observer.ArrayObserver;
import org.example.firsova.observer.ArrayObserverImpl;
import org.example.firsova.specification.ArraySpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RepositoryArrayImpl implements RepositoryArray {
    private static RepositoryArrayImpl instance;

    private final Set<ArrayInt> arrays = new HashSet<>();
    private final ArrayObserver observer = new ArrayObserverImpl();

    private RepositoryArrayImpl() {
    }

    public static RepositoryArrayImpl getInstance() {
        if (instance == null) {
            instance = new RepositoryArrayImpl();
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
