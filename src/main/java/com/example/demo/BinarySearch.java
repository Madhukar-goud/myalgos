package com.example.demo;

/**
 * Created by madhukar on 26/04/19.
 */
public class BinarySearch {

    int[] binarySearchArray;
    public BinarySearch(int[] sortedArray) {
        binarySearchArray = sortedArray;
    }

    public boolean checkIfExists(int p) {
        int low = 0;
        int high = binarySearchArray.length -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (p < binarySearchArray[mid]) {
                high = mid - 1;
            } else if (p > binarySearchArray[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
