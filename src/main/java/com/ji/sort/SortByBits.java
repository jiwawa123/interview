package com.ji.sort;

import java.util.*;

/**
 * user ji
 * data 2020/3/20
 * time 11:24 AM
 */
public class SortByBits {
    public static void main(String[] args) {

    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            if (!map.containsKey(arr[i])) {
                String tmp = Integer.toBinaryString(arr[i]);
                int count = 0;
                for (char t : tmp.toCharArray()) {
                    count += t == '1' ? 1 : 0;
                }
                map.put(arr[i], count);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
