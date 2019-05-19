package com.example.demo;

/**
 * Created by madhukar on 24/04/19.
 */
public class QuickUnion {

    int[] arrayOfNum;

    public QuickUnion(int N) {
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

    public int root(int p) {
        int i = p;
        while(i != arrayOfNum[i]) {
           i = arrayOfNum[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        arrayOfNum[i] = j;
    }

    public void printArray() {
        int i = 0;
        while(i < arrayOfNum.length) {
            System.out.println("Array at index ==> "+i+", Value is ==> "+arrayOfNum[i]);
            i++;
        }
    }
}
