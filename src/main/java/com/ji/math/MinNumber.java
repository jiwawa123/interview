package com.ji.math;/*
    user ji
    data 2020/3/9
    time 11:25 AM
*/

import java.util.*;

public class MinNumber {
    public static void main(String[] args) {

    }

    public String minNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int t:nums
             ) {
            list.add(t);
        }
        Collections.sort(list,new MyComparator());
        StringBuilder sp = new StringBuilder();
        for (int k:list
             ) {
            sp.append(k);
        }
        for (int i = 0; i < sp.length(); i++) {
            if(sp.charAt(i)!='0')
                return sp.substring(i).toString();
        }
        return sp.toString();

    }

    /**
     * 自定义排序规则
     */
    class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (""+o1+o2).compareTo(""+o2+o1);
        }
    }
}
