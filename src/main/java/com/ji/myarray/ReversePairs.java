package com.ji.myarray;

import java.util.ArrayList;
import java.util.List;

/**
 * user ji
 * data 2020/3/13
 * time 9:25 AM
 */
public class ReversePairs {
    public static void main(String[] args) {

        int arr[] = {7,5,6,4};

        System.out.println(reversePairs(arr));
    }

    public static int reversePairs(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count += getCOunt(list, nums[i]);
        }

        return count;
    }

    public static int getCOunt(List<Integer> list, int tmp) {
        if (list.size() == 0) {
            list.add(tmp);
            return 0;
        }

        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int med = (j - i) / 2 + i;
            if (list.get(med) <= tmp) {
                i = med + 1;
            } else {
                j = med - 1;
            }
        }
        int res = Math.max(0,list.size() - i);
        list.add(i, tmp);
        return res;
    }
}
