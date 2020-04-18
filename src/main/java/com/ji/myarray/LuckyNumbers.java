package com.ji.myarray;

import java.util.*;

/**
 * user ji
 * data 2020/3/15
 * time 7:59 PM
 */
public class LuckyNumbers {
    public static void main(String[] args) {

    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        Map<Integer,Integer> set = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            set.put(min,1);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            if(set.containsKey(max))
                res.add(max);
        }
        return res;
    }
}
