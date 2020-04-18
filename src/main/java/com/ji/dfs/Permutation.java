package com.ji.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * user ji
 * data 2020/3/13
 * time 11:06 AM
 */
public class Permutation {
    public static void main(String[] args) {
        new Permutation().permutation("ab");
    }

    boolean dfs[];

    public List<String> permutation(String s) {
        dfs = new boolean[s.length()];
        char tmp[] = s.toCharArray();
        Arrays.sort(tmp);
        List<String> res = new ArrayList<>();
        help("",tmp,res);
        res.forEach(System.out::println);
        return res;
    }

    public void help(String sp, char[] c, List<String> res) {
        if (sp.length() == c.length) {
            res.add(sp.toString());
        }
        for (int i = 0; i < c.length; i++) {
            if (dfs[i])
                continue;
            if (i > 0 && c[i] == c[i - 1] && !dfs[i - 1])
                continue;
            dfs[i] = true;
            help(sp+c[i], c, res);
            dfs[i] = false;
        }

    }
}
