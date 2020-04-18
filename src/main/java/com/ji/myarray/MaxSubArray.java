package com.ji.myarray;/*
    user ji
    data 2020/2/25
    time 9:07 AM
*/

public class MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (tmp < 0) {
                tmp = nums[i];
            } else {
                tmp += nums[i];
            }
            max = Math.max(max,tmp);
        }

        return max == Integer.MIN_VALUE ? 0 : max;

    }
}
