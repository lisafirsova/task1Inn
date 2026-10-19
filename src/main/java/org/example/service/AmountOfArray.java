package org.example.service;
import org.example.entity.ArrayInt;

import java.util.Optional;
public interface AmountOfArray {
    Optional<Integer> amountOf(ArrayInt arr);
}
