package com.ji.dp;

import java.util.*;

/**
 * user ji
 * data 2020/4/18
 * time 10:07 AM
 */
public class MaxScoreWords {

    // 分析情况，最坏的时候2^14 直接用暴力可以实现
    int scores[];

    class Current {
        int arr[];
        int score;

        public Current(int arr[], int score) {
            this.arr = arr;
            this.score = score;
        }
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        scores = score;
        List<Current> list = new LinkedList<>();
        int arr[] = new int[26];
        for (int i = 0; i < letters.length; i++) {
            arr[letters[i] - 'a'] += 1;
        }
        int result = 0;
        list.add(new Current(arr, 0));
        for (int i = 0; i < words.length; i++) {
            List<Current> inter = new ArrayList<>();
            for (Current c : list
                    ) {
                inter.add(c);
                int tmp[] = c.arr.clone();
                int res = help(tmp, words[i]);
                if (res > 0) {
                    result = Math.max(result, c.score + res);
                    inter.add(new Current(tmp, c.score + res));
                }
            }
            list = inter;

        }
        return result;
    }

    public int help(int tmp[], String word) {
        int res = 0;
        for (char a : word.toCharArray()
                ) {
            if (tmp[a - 'a'] > 0) {
                tmp[a - 'a']--;
                res += scores[a - 'a'];
            } else {
                return -1;
            }
        }
        return res;
    }
}
