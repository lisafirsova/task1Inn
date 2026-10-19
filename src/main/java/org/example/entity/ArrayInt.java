package org.example.entity;

import java.util.Arrays;
import java.util.Objects;

//toString, equals, hashCode.
public class ArrayInt {
    private final int arrayId;
    private final int[] array;

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
        int otherId = other.arrayId;
        return arrayId == otherId;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(arrayId);
    }
}
