package com.ji.status;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/4/18
 * time 9:06 AM
 */
public class FindTheLongestSubstring {
    public static void main(String[] args) {

    }
    private static final String VOWELS = "aeiou";
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = s.length();
        int state = 0; // (00000)
        int maxSize = 0;
        map.putIfAbsent(0, -1);
        for (int i = 0; i < size; i ++){
            for (int k = 0; k < VOWELS.length(); k++){
                if (s.charAt(i) == VOWELS.charAt(k)){
                    state ^= (1 << (VOWELS.length() - k - 1));
                    break;
                }
            }
            if (map.containsKey(state)){
                maxSize = Math.max(maxSize, i - map.get(state));
            }
            map.putIfAbsent(state, i);
        }
        return maxSize;
    }
}
