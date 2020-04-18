package com.ji.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * user ji
 * data 2020/3/17
 * time 9:02 AM
 */
public class SubSet {
    public static void main(String[] args) {
        List<String> res = new SubSet().subSet("abc");
        res.forEach(System.out::println);
    }

    List<String> res;

    public List<String> subSet(String s) {
        res = new ArrayList<>();
        help("", 0, s);
        return res;
    }

    public void help(String sp, int start, String s) {
        res.add(sp);
        for (int i = start; i < s.length(); i++) {
            sp += s.charAt(i);
            help(sp, i + 1, s);
            sp = sp.substring(0, sp.length() - 1);
        }
    }
}
