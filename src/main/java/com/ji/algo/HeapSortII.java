package com.ji.algo;

import java.util.Arrays;

/**
 * user ji
 * data 2020/3/16
 * time 9:52 AM
 */
public class HeapSortII {
    public static void main(String[] args) {
        int arr[] = {1,2,3,6,3,1,10,7};
        new HeapSortII().sort(arr);
    }

    public void sort(int arr[]) {
        //建堆
        for (int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length - 1);
        }
        swap(arr, 0, arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            adjustHeap(arr,0,i);
            swap(arr,0,i);
        }
        System.out.println(Arrays.toString(arr));
        //调整堆
    }

    /**
     * 调整堆
     */
    public void adjustHeap(int arr[], int i, int len) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int tmp = i;
        if (l <= len && arr[l] > arr[i]) {
            i = l;
        }
        if (r <= len && arr[r] > arr[l]) {
            i = r;
        }

        if (tmp != i) {
            swap(arr, i, tmp);
            adjustHeap(arr, i, len);
        }
    }

    /**
     * 交换两个数字
     */
    public void swap(int arr[], int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
