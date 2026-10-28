package com.firsova.task1.repository;

import com.firsova.task1.entity.ArrayInt;
import com.firsova.task1.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    boolean add(ArrayInt array);

    List<ArrayInt> findBy(ArraySpecification specification);

    boolean remove(int id);

    List<ArrayInt> sort(Comparator<ArrayInt> comparator);

    void clear();
}
