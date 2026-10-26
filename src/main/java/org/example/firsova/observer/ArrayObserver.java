package org.example.firsova.observer;

import org.example.firsova.entity.ArrayInt;

public interface ArrayObserver {
    void update(ArrayInt array);

    void delete(ArrayInt array);
}
