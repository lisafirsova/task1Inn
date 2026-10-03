package org.example.service;

import org.example.entity.ArrayInt;

public class SortingAlgorithms implements SortingAlgorithmsInterface {
    @Override
    public int[] bubbleSort(ArrayInt arrayInt) {
        int[] arr = arrayInt.getArray();
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int dummy = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = dummy;
                }
            }
        }
        return arr;
    }

    @Override
    public ArrayInt quickSort(ArrayInt arrayInt) {
        int[] array = arrayInt.getArray();
        if (array.length <= 1) {
            return new ArrayInt(array);
        }
        int pivot = array[array.length / 2];
        int leftCount = 0;
        int rightCount = 0;
        int equalCount = 0;
        for (int element : array) {
            if (element < pivot) {
                leftCount++;
            } else if (element > pivot) {
                rightCount++;
            } else {
                equalCount++;
            }
        }
        int[] left = new int[leftCount];
        int[] right = new int[rightCount];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int element : array) {
            if (element < pivot) {
                left[leftIndex] = element;
                leftIndex++;
            } else if (element > pivot) {
                right[rightIndex] = element;
                rightIndex++;
            }
        }
        int[] sortedLeft = quickSort(new ArrayInt(left)).getArray();
        int[] sortedRight = quickSort(new ArrayInt(right)).getArray();
        int[] result = new int[array.length];
        int index = 0;
        for (int element : sortedLeft) {
            result[index] = element;
            index++;
        }
        for (int i = 0; i < equalCount; i++) {
            result[index] = pivot;
            index++;
        }
        for (int element : sortedRight) {
            result[index] = element;
            index++;
        }
        return new ArrayInt(result);
    }
}
