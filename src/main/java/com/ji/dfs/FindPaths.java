package com.ji.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/4/22
 * time 4:14 PM
 */
public class FindPaths {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        new FindPaths().findPaths(8, 7, 16, 1, 5);
        System.out.println(System.currentTimeMillis() - a);
    }

    Map<String, Integer> map = new HashMap<>();

    public int findPaths(int m, int n, int N, int i, int j) {
        //map保存的是从[i,j]走到[x,y]后剩余步数为N再走到边界的路径数
        return dfs(m, n, N, i, j);
    }

    public int dfs(int m, int n, int N, int i, int j) {
        if (N < 0) return 0;
        if (N < i + 1 && N < j + 1 && N < m - i && N < n - j) return 0;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (map.containsKey(i + "," + j + "," + N)) {
            return map.get(i + "," + j + "," + N);
        }
        int count = 0;
        count = (count + dfs(m, n, N - 1, i + 1, j)) % 1000000007;
        count = (count + dfs(m, n, N - 1, i - 1, j)) % 1000000007;
        count = (count + dfs(m, n, N - 1, i, j + 1)) % 1000000007;
        count = (count + dfs(m, n, N - 1, i, j - 1)) % 1000000007;
        map.put(i + "," + j + "," + N, count);
        return count;
    }
}
