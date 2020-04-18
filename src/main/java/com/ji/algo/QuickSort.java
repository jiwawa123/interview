package com.ji.algo;/*
    user ji
    data 2019/10/20
    time 3:40 PM
*/

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {0,1,23,8,2, 3, 4, 1, 40, 420, 1, 20, 30, 1, 2, 0, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int i = start, j = end;
        while (i < j) {
            while (arr[j] >= arr[start] && i < j) {
                j--;
            }
            while (arr[i] <= arr[start] && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, start, i);
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
