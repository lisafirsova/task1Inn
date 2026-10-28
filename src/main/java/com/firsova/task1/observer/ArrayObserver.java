package com.firsova.task1.observer;

import com.firsova.task1.entity.ArrayInt;

public interface ArrayObserver {
    void update(ArrayInt array);

    void delete(ArrayInt array);
}
