package org.example.repository;

import org.example.entity.ArrayInt;
import org.example.exception.ArrayException;
import org.example.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface RepositoryForArray {
    boolean addElement(ArrayInt array) throws ArrayException;
    List<ArrayInt> findBy(ArraySpecification specification) throws ArrayException;

    boolean remove(int id) throws ArrayException;

    List<ArrayInt> sort(Comparator<ArrayInt> comparator) throws ArrayException;

    void clear() throws ArrayException;
}
