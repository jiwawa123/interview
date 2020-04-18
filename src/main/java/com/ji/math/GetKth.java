package com.ji.math;

import java.util.*;

/**
 * user ji
 * data 2020/3/24
 * time 7:13 PM
 */
public class GetKth {
    public static void main(String[] args) {

    }

    int path = 0;

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            path = 0;
            computer(lo,0);
            map.put(lo,path);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        return list.get(k);
    }

    public void computer(int k, int len) {
        if (k == 1) {
            path = len;
            return;
        }
        if (k % 2 == 0) {
            k /= 2;
            computer(k, len + 1);
        } else {
            k = 3 * k + 1;
            computer(k, len + 1);
        }
    }
}
