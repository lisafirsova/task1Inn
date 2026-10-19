package org.example.service;
import org.example.entity.ArrayInt;

import java.util.Optional;
public interface SearchForMinAndMax {
    Optional<Integer> findMin(ArrayInt arr);
    Optional<Integer> findMax(ArrayInt arr);

}
