package com.example.demo;

/**
 * Created by madhukar on 24/04/19.
 */
public class QuickFind {

    int[] arrayOfNum;
    public QuickFind(int N) {
        arrayOfNum = new int[N];
        initialize(N);
    }

    public void initialize(int N) {
        int i = 0;
        while(i != N) {
            arrayOfNum[i] = i;
            i++;
        }
    }

    public boolean connected(int p, int q) {
        return arrayOfNum[p] == arrayOfNum[q];
    }

    public void union(int p, int q) {
        int prevValue = arrayOfNum[p];
        int i = 0;
        while(i < arrayOfNum.length) {
            if (arrayOfNum[i] == prevValue) {
                arrayOfNum[i] = arrayOfNum[q];
            }
            i++;
        }
    }

    public void printArray() {
        int i = 0;
        while(i < arrayOfNum.length) {
            System.out.println("Array at index ==> "+i+", Value is ==> "+arrayOfNum[i]);
            i++;
        }
    }
}

