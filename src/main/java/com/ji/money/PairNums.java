package com.ji.money;

import java.util.*;

/**
 * user ji
 * data 2020/3/10
 * time 9:41 AM
 */

public class PairNums {
    public static void main(String[] args) {
        int arr[] = {5, 6, 5};
        System.out.println(pairSums(arr, 11));
    }

    public static List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(target - nums[i], 0) > 0) {
                List<Integer> tmp = Arrays.asList(nums[i], target-nums[i]);
                res.add(tmp);
                map.put(target - nums[i], map.get(target - nums[i]) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return res;
    }
}
