package com.ji.math;/*
    user ji
    data 2020/2/28
    time 10:04 PM
*/

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(1)));
    }

    public static double[] twoSum(int n) {
        Map<Integer, Double> map = new HashMap<>();
        map.put(0,1.0);
        for (int i = 0; i < n; i++) {
            Map<Integer, Double> tmp = new HashMap<>();
            for (Map.Entry<Integer, Double> entry: map.entrySet()
                    ) {
                for (int j = 1; j < 7; j++) {
                    tmp.put(j+entry.getKey(),tmp.getOrDefault(j+entry.getKey(),0.0)+entry.getValue()*1.0/6);
                }
            }
            map = tmp;

        }
        double[] res = new double[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Double> entry: map.entrySet()
             ) {
            res[i++] = entry.getValue();
        }
        return res;
    }
}
