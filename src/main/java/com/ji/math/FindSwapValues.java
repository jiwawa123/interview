package com.ji.math;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/3/24
 * time 9:40 AM
 */
public class FindSwapValues {
    public static void main(String[] args) {

    }

    public int[] findSwapValues(int[] array1, int[] array2) {
        int count1 = 0;
        int count2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : array1
                ) {
            count1 += k;
        }
        for (int k : array2
                ) {
            map.put(k, 1);
            count2 += k;
        }
        int res[] = new int[0];
        if ((count2 - count1) % 2 != 0) {
            return res;
        }
        for (int t : array1
                ) {
            int target = (count2 - count1) / 2 + t;
            if (map.containsKey(target)) {
                int result[] = new int[2];
                result[0] = t;
                result[1] = target;
                return result;
            }
        }
        return res;
    }
}
