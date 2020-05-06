package com.ji.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * user ji
 * data 2020/5/4
 * time 3:11 下午
 */
public class JumpII {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {

        int arr[] = new int[nums.length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + nums[i] && j < nums.length; j++) {
                arr[j] = Math.max(arr[j], arr[i] + 1);
            }
        }
        return arr[nums.length - 1];
    }
}
