package com.ji.myhashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/5/14
 * time 9:19 上午
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    // 使用map+一个向前的指针即可
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        char tmp[] = s.toCharArray();
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(tmp[i])) {
                last = Math.max(res, map.get(tmp[i]) + 1);
            }
            map.put(tmp[i], i);
            res = Math.max(res, i - last + 1);
        }
        return res;
    }

}
