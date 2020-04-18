package com.ji.offer;/*
    user ji
    data 2020/2/12
    time 6:09 PM
*/

import java.util.ArrayList;
import java.util.List;

public class MaxSlidingWindow {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length + 1 - k];
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            tmp.add(nums[i]);
        }
        int t = 0;
        res[t] = maxList(tmp);
        for (int i = k; i < nums.length; i++) {
            tmp.remove(0);
            tmp.add(nums[i]);
            res[t++] = maxList(tmp);
        }

        return res;
    }

    public int maxList(List<Integer> list){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max,list.get(i));
        }
        return max;
    }
}
