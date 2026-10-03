package org.example.entity;

import java.util.Arrays;
import java.util.Objects;

//toString, equals, hashCode.
public class ArrayInt {
    private final int[] array;

    public int[] getArray() {
        return array.clone();
    }

    public ArrayInt(int[] array) {
        this.array = array.clone();
    }

    @Override
    public String toString() {
        return "Array: " + Arrays.toString(array);
    }

    @Override
    public boolean equals(Object obj) {
        ArrayInt other = (ArrayInt) obj;
        int[] otherArray = other.array;
        if (array.length != otherArray.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != otherArray[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int element : array) {
            result = 17 * result + element;
        }
        return result;
    }
}
