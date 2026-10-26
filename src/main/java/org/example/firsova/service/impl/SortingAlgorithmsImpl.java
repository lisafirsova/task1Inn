package org.example.firsova.service.impl;

import org.example.firsova.entity.ArrayInt;
import org.example.firsova.service.SortingAlgorithms;

public class SortingAlgorithmsImpl implements SortingAlgorithms {
    @Override
    public int[] bubbleSort(ArrayInt arrayInt) {
        int[] arr = arrayInt.getArray();
        for (int i = arr.length - 1; i >= 1; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    @Override
    public int[] quickSort(ArrayInt arrayInt) {
        int[] arr = arrayInt.getArray();
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[low + (high - low) / 2];
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        quickSort(arr, low, j);
        quickSort(arr, i, high);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
