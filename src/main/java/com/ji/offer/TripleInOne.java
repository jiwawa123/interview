package com.ji.offer;/*
    user ji
    data 2020/2/18
    time 10:00 AM
*/

import java.util.Arrays;

public class TripleInOne {
    int arr[][];


    public TripleInOne(int stackSize) {
        arr = new int[3][stackSize + 1];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(arr[i], -1);
        }
        arr[0][0] = 0;
        arr[1][0] = 0;
        arr[2][0] = 0;
    }

    public void push(int stackNum, int value) {
        if (arr[stackNum][0] == arr[0].length - 1) {
            return;
        } else {
            arr[stackNum][arr[stackNum][0] + 1] = value;
            arr[stackNum][0] += 1;
        }
    }

    public int pop(int stackNum) {
        if (arr[stackNum][0] == 0)
            return -1;
        int res = arr[stackNum][arr[stackNum][0]];
        arr[stackNum][0] -= 1;
        return res;
    }

    public int peek(int stackNum) {
        return arr[stackNum][0] == 0 ? -1 : arr[stackNum][arr[stackNum][0]];
    }

    public boolean isEmpty(int stackNum) {
        return arr[stackNum][0] == 0;
    }
}
