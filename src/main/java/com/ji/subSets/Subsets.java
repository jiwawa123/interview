package com.ji.subSets;/*
    user ji
    data 2020/3/2
    time 9:24 AM
*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        help(res,new ArrayList<>(),0,nums);
        return res;
    }

    public void help(List<List<Integer>> res,List<Integer> tmp,int start,int nums[]){
        res.add(new ArrayList<>(tmp));
        for (int i = start; i <nums.length ; i++) {
            tmp.add(nums[i]);
            help(res,tmp,i+1,nums);
            tmp.remove(nums[i]);
        }
    }
}
