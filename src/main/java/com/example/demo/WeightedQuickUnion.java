package com.example.demo;

/**
 * Created by madhukar on 24/04/19.
 */
public class WeightedQuickUnion {

    int[] arrayOfNum;
    int[] rootSize;
    int[] maxOfConnected;

    public WeightedQuickUnion(int N) {
        arrayOfNum = new int[N];
        rootSize  = new int[N];
        maxOfConnected = new int[N];
        initialize(N);
    }

    public void initialize(int N) {
        int i = 0;
        while(i != N) {
            arrayOfNum[i] = i;
            rootSize[i] = 0;
            maxOfConnected[i] = i;
            i++;
        }
    }

    public int root(int p) {
        int i = p;
        int iRootSize = 0;
        while(i != arrayOfNum[i]) {
            arrayOfNum[i] = arrayOfNum[arrayOfNum[i]];
            if (maxOfConnected[i] < arrayOfNum[i]) {
                maxOfConnected[i] = arrayOfNum[i];
            }
            i = arrayOfNum[i];
            iRootSize++;
        }
        rootSize[p] = iRootSize;
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (rootSize[p] >= rootSize[q]) {
            System.out.println("root size of P " + rootSize[p]);
            System.out.println("root size of Q " + rootSize[q]);
            arrayOfNum[j] = i;
        } else {
            arrayOfNum[i] = j;
        }

    }

    public void printArray() {
        int i = 0;
        while(i < arrayOfNum.length) {
            System.out.println("Array at index ==> "+i+", Value is ==> "+arrayOfNum[i]);
            i++;
        }
        i = 0;
        while(i < maxOfConnected.length) {
            System.out.println("MAX Array at index ==> "+i+", Value is ==> "+arrayOfNum[i]);
            i++;
        }
    }

    public int find(int i) {
        return maxOfConnected[i];
    }
}
