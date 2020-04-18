package com.ji.myarray;/*
    user ji
    data 2020/3/10
    time 9:09 AM
*/

public class FindClosest {
    public static void main(String[] args) {
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        System.out.println(findClosest(words,"a","student"));
    }

    public static int findClosest(String[] words, String word1, String word2) {
        int dep = Integer.MAX_VALUE;
        int w1 = -1;
        int w2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                w1 = i;
                if (w2 != -1) {
                    dep = Math.min(dep, Math.abs(w1 - w2));
                }
            }

            if (word2.equals(words[i])) {
                w2 = i;
                if (w1 != -1) {
                    dep = Math.min(dep, Math.abs(w1 - w2));
                }
            }
        }

        return dep;
    }
}
