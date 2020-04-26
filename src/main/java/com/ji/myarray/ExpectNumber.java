package com.ji.myarray;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/4/26
 * time 9:01 上午
 */
public class ExpectNumber {
    public static void main(String[] args) {

    }

    //数学归纳法即可证明

    public int expectNumber(int[] scores) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            map.put(scores[i], map.getOrDefault(scores[i], 0) + 1);
        }
        return map.size();
    }
}
