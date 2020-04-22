package com.ji.MutilPointer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * user ji
 * data 2020/4/21
 * time 10:48 AM
 */
public class NumberOfSubarrays {
    public static void main(String[] args) {

    }

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                index++;
                map.put(index, i);
            }
        }
        if (nums[nums.length - 1] % 2 == 0) {
            map.put(index + 1, nums.length);
        }
        if (index < k)
            return 0;
        for (int i = 1; i <= index; i++) {
            if (!map.containsKey(i + k - 1))
                break;
            int len = nums.length;
            if (map.containsKey(i + k)) {
                len = map.get(i + k);
            }
            sum += (map.get(i) - map.get(i - 1)) * (len - map.get(i + k - 1));
        }
        return sum;
    }
}
