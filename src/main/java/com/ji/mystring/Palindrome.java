package com.ji.mystring;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/3/19
 * time 9:40 AM
 */
public class Palindrome {
    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char a : s.toCharArray()
                ) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int count = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> e : map.entrySet()
                ) {
            if (e.getValue() % 2 == 0)
                count += e.getValue();
            else {
                flag = true;
                count += e.getValue() - 1;
            }

        }
        return count + (flag ? 1 : 0);
    }
}
