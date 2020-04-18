package com.ji.dfs;

import java.util.Collections;
import java.util.List;

/**
 * user ji
 * data 2020/3/16
 * time 8:54 PM
 */
public class PondSizes {
    public static void main(String[] args) {
        int arr[][] = {{0, 0}};
        System.out.println(new PondSizes().pondSizes(arr));
    }

    List<Integer> list;
    int tmp = 0;
    boolean flag[][];

    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] > 0 || flag[i][j])
                    continue;
                tmp = 0;
                help(i, j, m, n, land);
                if (tmp > 0) list.add(tmp);
            }
        }

        Collections.sort(list);
        int res[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void help(int i, int j, int m, int n, int[][] land) {
        if (i < 0 || j < 0 || i >= m || j >= n || land[i][j] > 0 || flag[i][j])
            return;
        flag[i][j] = true;
        tmp += 1;
        help(i - 1, j, m, n, land);
        help(i, j - 1, m, n, land);
        help(i + 1, j, m, n, land);
        help(i, j + 1, m, n, land);
        help(i - 1, j + 1, m, n, land);
        help(i + 1, j + 1, m, n, land);
        help(i - 1, j - 1, m, n, land);
        help(i + 1, j - 1, m, n, land);
    }
}
