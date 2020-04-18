package com.ji.myarray;

import java.util.Arrays;

/**
 * user ji
 * data 2020/3/24
 * time 6:54 PM
 */
public class FindTheDistanceValue {
    public static void main(String[] args) {
        int arr[] = {1,4,2,3};
        int arr1[] = {-4,-3,6,10,20,30};
        System.out.println(findTheDistanceValue(arr,arr1,3));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        boolean flag = true;
        for (int t : arr1
                ) {
             flag = true;
            for (int i = 0; i < arr2.length; i++) {
                if (arr2[i] >= t - d && arr2[i] <= t + d) {
                    flag = false;
                    break;
                }
                if (arr2[i] > t + d)
                    break;
            }
            if (flag)
                res += 1;
        }
        return res;
    }
}
