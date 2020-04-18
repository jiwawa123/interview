package com.ji.math;/*
    user ji
    data 2020/3/6
    time 11:19 AM
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindContinuousSequence {
    public static void main(String[] args) {

    }

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> res = new LinkedList();
        for (int i = 1; i < target / 2; i++) {
            int count = i;
            List<Integer> tmp = new ArrayList<>();
            tmp.add(count);
            for (int j = i + 1; j < target; j++) {
                count += j;
                tmp.add(j);
                if (count == target) {
                    res.add(tmp);
                    break;
                }
                if (count > target) {
                    break;
                }
            }
        }

        int[][] tmp = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            tmp[i] = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size() ; j++) {
                tmp[i][j] = res.get(i).get(j);
            }
        }
        return tmp;
    }
}
