package com.ji.algo;/*
    user ji
    data 2019/10/26
    time 3:20 PM
*/

import java.util.HashMap;
import java.util.Map;

public class G1 {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : J.toCharArray()
                ) {
            map.put(c, 1);
        }
        int count = 0;
        for (char t : S.toCharArray()
                ) {
            count += map.containsKey(t) ? 1 : 0;
        }
        return count;
    }
}
