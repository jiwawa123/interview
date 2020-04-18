package com.ji.myarray;

import java.util.ArrayList;
import java.util.List;

/**
 * user ji
 * data 2020/3/14
 * time 7:15 PM
 */
public class LengthOfLISII {
    public static void main(String[] args) {
        int arr[] = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int t : nums
                ) {
            help(list, t);
            res = Math.max(res, list.size());
        }
        return res;
    }

    public static void help(List<Integer> list, int num) {
        if (list.size() == 0 || list.get(list.size() - 1) < num) {
            list.add(num);
            return;
        }

        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int med = (j - i) / 2 + i;
            if (list.get(med) == num) {
                return;
            } else if (list.get(med) < num) {
                i = med + 1;
            } else {
                j = med - 1;
            }

        }
        list.set(i, Math.min(list.get(i),num));
    }
}
