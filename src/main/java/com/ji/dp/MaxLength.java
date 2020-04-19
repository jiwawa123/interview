package com.ji.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * user ji
 * data 2020/4/18
 * time 10:24 AM
 */
public class MaxLength {
    public static void main(String[] args) {
        String arr[] = {"yy","bkhwmpbiisbldzknpm"};
        new MaxLength().maxLength(Arrays.asList(arr));
    }

    class Current {
        int arr[];
        int len;

        Current(int arr[], int len) {
            this.arr = arr;
            this.len = len;
        }
    }

    public int maxLength(List<String> arr) {
        int res = 0;
        List<Current> list = new LinkedList<>();
        list.add(new Current(new int[26], 0));
        for (int i = 0; i < arr.size(); i++) {
            List<Current> inter = new LinkedList<>();
            for (Current c : list
                    ) {
                inter.add(c);
                int tmp[] = c.arr.clone();
                if (help(tmp, arr.get(i))) {
                    res = Math.max(res, c.len + arr.get(i).length());
                    inter.add(new Current(tmp, c.len + arr.get(i).length()));
                }
            }
            list = inter;
        }

        return res;
    }

    public boolean help(int tmp[], String word) {
        for (char a : word.toCharArray()
                ) {
            if (tmp[a - 'a'] > 0) {
                return false;
            }
            tmp[a - 'a'] += 1;
        }
        return true;
    }
}
