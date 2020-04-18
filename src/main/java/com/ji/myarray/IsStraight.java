package com.ji.myarray;

/**
 * user ji
 * data 2020/3/14
 * time 7:31 PM
 */
public class IsStraight {
    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {
        int arr[] = new int[13];
        int min = 14;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            if (arr[nums[i]] > 0)
                return false;
            arr[nums[i]] += 1;
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if (max - min > 4)
                return false;
        }
        return true;
    }
}
