package com.ji.datastructed;

import java.util.ArrayList;
import java.util.List;

/**
 * user ji
 * data 2020/3/20
 * time 9:15 AM
 */
public class MedianFinder {

    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int med = (j - i) / 2 + i;
            if (list.get(med) == num) {
                i = med;
                break;
            } else if (list.get(med) < num) {
                i = med + 1;
            } else {
                j = med - 1;
            }
        }
        if(i==list.size()){
            list.add(num);
        }else{
            list.add(i, num);
        }
    }

    public double findMedian() {
        if (list.size() % 2 == 0) {
            return 1.0 * (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
        } else {
            return list.get(list.size() / 2) * 1.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
    }
}
