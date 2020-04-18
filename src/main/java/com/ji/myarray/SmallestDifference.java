package com.ji.myarray;

import java.util.Arrays;

/**
 * user ji
 * data 2020/3/16
 * time 8:38 PM
 */
public class SmallestDifference {
    public static void main(String[] args) {
        int a[] = {-2147483648, 1};
        int b[] = {2147483647, 0};
        System.out.println(smallestDifference(a, b));
    }

    public static int smallestDifference(int[] a, int[] b) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if(Math.abs(a[i] - b[j])!=-2147483648)
                res = Math.min(res, Math.max(0,Math.abs(a[i] - b[j])));
            if (res == 0)
                return 0;
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return res;
    }
}
