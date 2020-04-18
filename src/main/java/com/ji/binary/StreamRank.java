package com.ji.binary;/*
    user ji
    data 2020/2/25
    time 10:18 AM
*/

import java.util.ArrayList;
import java.util.List;

public class StreamRank {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        list.add(0,3);
//        list.stream().forEach(System.out::println);
//        System.out.println(getIndex(3,list));
    }

    List<Integer> list = new ArrayList<>();

    public StreamRank() {

    }

    public void track(int x) {
        int index = getIndex(x,list);
        list.add(index,x);
    }
    public int getRankOfNumber(int x) {
        return getIndex(x,list);
    }
    public static int getIndex(int x, List<Integer> list) {
        if (null == list || list.size() == 0)
            return 0;
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int med = (j - i) / 2 + i;
            if (list.get(med) <= x) {
                i = med + 1;
            }else{
                j = med - 1 ;
            }
        }
        return i;
    }

}
