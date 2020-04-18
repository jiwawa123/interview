package com.ji.myarray;

/**
 * user ji
 * data 2020/3/16
 * time 9:01 AM
 */
public class Exchange {
    public static void main(String[] args) {

    }

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 1) {
                i++;
            } else {
                while (nums[j] % 2 == 0 && i < j) {
                    j--;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }
}
