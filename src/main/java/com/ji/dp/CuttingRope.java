package com.ji.dp;

/**
 * user ji
 * data 2020/3/16
 * time 9:08 AM
 */
public class CuttingRope {
    public static void main(String[] args) {

    }

    public int cuttingRope(int n) {
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            int p = 1, q = i - 1;
            int res = Integer.MIN_VALUE;
            while (p <= q) {
                res = Math.max(res, arr[p] * arr[q]);
                res = Math.max(res, p * q);
                res = Math.max(res, arr[p] * q);
                res = Math.max(res, p * arr[q]);
                p++;
                q--;
            }
            arr[i] = res;
        }
        return arr[n];
    }
}
