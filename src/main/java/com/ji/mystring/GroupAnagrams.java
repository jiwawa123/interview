package com.ji.mystring;/*
    user ji
    data 2020/3/2
    time 8:37 AM
*/

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        List<List<String>> res = new ArrayList<>();
        for (String tmp : strs
                ) {
            char[] chars = tmp.toCharArray();
            Arrays.sort(chars);
            List<String> inter = map.getOrDefault(String.valueOf(chars),new ArrayList<>());
            inter.add(tmp);
            map.put(String.valueOf(chars),inter);
        }
        for (List<String> list : map.values()
                ) {
            res.add(list);
        }

        return res;
    }
}
