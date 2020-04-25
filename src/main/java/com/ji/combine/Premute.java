package com.ji.combine;

import java.lang.reflect.Array;
import java.util.*;

/**
 * user ji
 * data 2020/4/25
 * time 9:56 上午
 */
public class Premute {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        new Premute().permute(arr).forEach(System.out::println);
    }

    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        help(nums, new LinkedList<>(), new HashMap<>());
        return res;
    }

    private void help(int[] nums, List<Integer> list, Map<Integer, Integer> map) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                list.add(nums[i]);
                help(nums, list, map);
                map.remove(nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
