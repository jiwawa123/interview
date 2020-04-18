package com.ji.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * user ji
 * data 2020/4/9
 * time 12:27 PM
 */
public class Parentesis {
    public static void main(String[] args) {
       List arrayList = new Parentesis().generateParenthesis(3);
       arrayList.forEach(System.out::println);
    }

    Set<String> set = new HashSet<>();

    public List<String> generateParenthesis(int n) {
        help(0,0,n,"");
        return new ArrayList<>(set);
    }

    public void help(int l, int r, int n, String tmp) {
        if (l == n && r == n) {
            set.add(tmp);
            return;
        }
        if (l > n || r > l)
            return;
        help(l + 1, r, n, tmp + "(");
        if (r < l) {
            help(l, r + 1, n, tmp + ")");
        }
    }
}
