package com.ji.mystring;/*
    user ji
    data 2020/2/25
    time 8:46 AM
*/

import java.util.ArrayList;
import java.util.List;

public class ValidString {
    public static void main(String[] args) {
        String num = "8733";
        String words[] = {"tree", "used"};
        List<String> res = getValidT9Words(num, words);
        res.stream().forEach(System.out::println);
    }

    public static List<String> getValidT9Words(String num, String[] words) {
        String tmp[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int arr[] = new int[num.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num.charAt(i) - '1';
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != num.length())
                continue;
            int cnt = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (tmp[arr[j] - 1].contains(words[i].charAt(j) + "")) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == num.length()) {
                res.add(words[i]);
            }
        }

        return res;
    }
}
