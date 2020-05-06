package com.ji.mymap;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/4/28
 * time 8:43 上午
 */
public class SingleNumbers {
    public static void main(String[] args) {

    }

    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums
        ) {
            if (map.containsKey(k))
                map.remove(k);
            else
                map.put(k, 1);
        }

//        int res[] = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        int res[] = new int[2];
        int index = 0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            res[index++] = entry.getValue();
        }

        return res;
    }
}
