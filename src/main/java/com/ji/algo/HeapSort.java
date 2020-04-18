package com.ji.algo;/*
    user ji
    data 2019/10/20
    time 3:27 PM
*/

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 1, 0, 8, 2, 3, 1, 10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int arr[]) {
        bulid_heap(arr);
        swap(arr, 0, arr.length - 1);
        for (int i = arr.length - 2; i >= 1; i--) {
            adj_heap(arr, 0, i);
            swap(arr, 0, i);
        }
    }

    private static void adj_heap(int[] arr, int i, int len) {
        if (i > len)
            return;
        int le = i * 2 + 1;
        int ri = i * 2 + 2;
        int f = i;
        if (le <= len && arr[f] < arr[le]) {
            f = le;
        }
        if (ri <= len && arr[f] < arr[ri]) {
            f = ri;
        }
        if (f != i) {
            swap(arr, f, i);
            adj_heap(arr, f, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void bulid_heap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            adj_heap(arr, i, arr.length - 1);
        }
    }
}
