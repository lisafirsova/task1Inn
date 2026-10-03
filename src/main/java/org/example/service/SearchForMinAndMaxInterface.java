package org.example.service;
import org.example.entity.ArrayInt;

import java.util.Optional;
public interface SearchForMinAndMaxInterface{
    public Optional<Integer> findMin(ArrayInt arr);
    public Optional<Integer> findMax(ArrayInt arr);

}
