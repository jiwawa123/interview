package com.ji.math;

import java.util.Arrays;

/**
 * user ji
 * data 2020/3/14
 * time 7:56 PM
 */
public class GetKthMagicNumber {
    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(3));
    }

    public static int getKthMagicNumber(int k) {
        if (k == 1)
            return 1;
        int arr[] = new int[k];
        arr[0] = 1;
        int l = 0, f = 0, s = 0;
        for (int i = 1; i < k; i++) {
            int min = Math.min(arr[l] * 3, Math.min(arr[f] * 5, arr[s] * 7));
            if (arr[l] * 3 == min) {
                l++;
            }
            if (arr[f] * 5 == min) {
                f++;
            }
            if (arr[s] * 7 == min)
                s++;
            arr[i] = min;
        }
        return arr[k - 1];
    }
}
