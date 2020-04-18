package com.ji.myarray;

import java.util.ArrayList;
import java.util.List;

/**
 * user ji
 * data 2020/3/13
 * time 10:52 AM
 */
public class MedianFinder {
    List<Integer> list = new ArrayList<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        getCOunt(list, num);
    }

    public double findMedian() {
        if (list.size() % 2 == 0) {
            return 1.0 * (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
        } else {
            return 1.0 * list.get(list.size() / 2);
        }
    }

    public void getCOunt(List<Integer> list, int tmp) {
        if (list.size() == 0) {
            list.add(tmp);
            return;
        }

        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int med = (j - i) / 2 + i;
            if (list.get(med) <= tmp) {
                i = med + 1;
            } else {
                j = med - 1;
            }
        }
        list.add(i, tmp);
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
