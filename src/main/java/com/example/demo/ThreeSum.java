package com.example.demo;

import java.util.Arrays;

/**
 * Created by madhukar on 26/04/19.
 */
public class ThreeSum {

    int[] initArray;

    public ThreeSum(int[] array1) {
        initArray = array1;
        sortArray();
    }

    public void sortArray() {
        Arrays.sort(initArray);
    }

    public void check3Sum() {
        BinarySearch binarySearch = new BinarySearch(initArray);
        int size = initArray.length;
        int count = 0;
        for(int i=0; i < size; i++) {
            for (int j = i+1; j< size; j++) {
                int sum = - (initArray[i]+ initArray[j]);
                if(binarySearch.checkIfExists(sum)) {
                    count++;
                }
            }
        }

    }
}
