package com.ji.binary;/*
    user ji
    data 2020/2/26
    time 9:31 AM
*/

import java.util.Arrays;

public class FindMagicIndex {
    public static void main(String[] args) {

    }

    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0 || nums[nums.length - 1] < 0)
            return -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int med = (j - i) / 2 + i;
            if (nums[med] == med) {
                int l = findMagicIndex(Arrays.copyOfRange(nums, 0, med - 1));
                return l == -1 ? med : l;
            }

        }


        return -1;
    }


}
