package com.firsova.task1.entity;

import com.firsova.task1.exception.ArrayException;
import com.firsova.task1.observer.ArrayObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayInt {
    private final int arrayId;
    private final int[] array;
    private final List<ArrayObserver> observers = new ArrayList<>();

    public ArrayInt(int arrayId, int[] array) {
        this.arrayId = arrayId;
        this.array = array.clone();
    }

    public int[] getArray() {
        return array.clone();
    }

    public int getArrayId() {
        return arrayId;
    }

    public int getLength() {
        return array.length;
    }

    public void setElement(int index, int value) throws ArrayException {
        if (index < 0 || index >= array.length) {
            throw new ArrayException("Index " + index + " is out of bounds for length " + array.length);
        }
        array[index] = value;
        notifyObservers();
    }

    public void attach(ArrayObserver observer) {
        observers.add(observer);
    }

    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ArrayObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Id of array: " + arrayId + ", array: " + Arrays.toString(array);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArrayInt other = (ArrayInt) obj;
        return arrayId == other.arrayId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(arrayId);
    }
}
