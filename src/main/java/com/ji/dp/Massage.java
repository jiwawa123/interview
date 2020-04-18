package com.ji.dp;

/**
 * user ji
 * data 2020/3/16
 * time 8:49 AM
 */
public class Massage {
    public static void main(String[] args) {

    }

    public int massage(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int arr[] = new int[nums.length];
        arr[0] = nums[0];
        if (nums.length == 1)
            return arr[0];
        arr[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i]);
        }
        return nums[nums.length - 1];
    }

    public int massageII(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int f = nums[0];
        int s = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            int tmp = s;
            s = Math.max(s,f+nums[i]);
            f = tmp;
        }
        return s;

    }
}
