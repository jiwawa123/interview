package com.ji.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * user ji
 * data 2020/3/14
 * time 7:42 PM
 */
public class LastRemaining {
    public static void main(String[] args) {

    }

    public int lastRemaining(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }
}
