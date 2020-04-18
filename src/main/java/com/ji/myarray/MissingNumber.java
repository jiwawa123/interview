package com.ji.myarray;/*
    user ji
    data 2020/2/26
    time 9:56 AM
*/

public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {2,0};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (Math.abs(nums[i]) == len)
                continue;
            if (nums[Math.abs(nums[i])] == 0) {
                flag = true;
            }
            nums[Math.abs(nums[i])] *= -1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                return i;
            if (nums[i] == 0) {
                if (!flag)
                    return i;
            }
        }
        return len;
    }
}
