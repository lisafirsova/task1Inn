package org.example.firsova.repository;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface RepositoryArray {
    boolean add(ArrayInt array);

    List<ArrayInt> findBy(ArraySpecification specification);

    boolean remove(int id);

    List<ArrayInt> sort(Comparator<ArrayInt> comparator);

    void clear();
}
