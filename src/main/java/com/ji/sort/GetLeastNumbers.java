package com.ji.sort;

/**
 * user ji
 * data 2020/3/20
 * time 8:51 AM
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int arr[] = {0,0,1,2,4,2,2,3,1,4};
        new GetLeastNumbers().getLeastNumbers(arr,8);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int res[] = new int[k];
        for (int i = arr.length / 2; i >= 0; i--) {
            adjust(i, arr.length - 1, arr);
        }
        swap(arr, 0, arr.length - 1);
        int t = 1;
        for (int i = arr.length - 2; i >= 0 && t < k; i--) {
            adjust(0, i, arr);
            swap(arr, 0, i);
            t++;
        }
        for (int i = 0; i < k; i++) {
            res[i] = arr[arr.length - 1];
        }
        return res;
    }


    public void adjust(int i, int len, int arr[]) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int tmp = i;
        if (l <= len && arr[l] < arr[i]) {
            i = l;
        }
        if (r <= len && arr[r] < arr[i]) {
            i = r;
        }
        if (tmp != i) {
            swap(arr, tmp, i);
            adjust(i, len, arr);
        }
    }

    public void swap(int arr[], int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
