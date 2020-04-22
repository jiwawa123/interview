package com.ji.dfs;

import java.util.Arrays;

/**
 * user ji
 * data 2020/4/20
 * time 6:32 PM
 */
public class NumIsland {
    public static void main(String[] args) {

    }

    int arr[][];
    int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        arr = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && arr[i][j] == 0) {
                    res++;
                    help(i,j,res,grid);
                }
            }
        }
        return res;
    }

    public void help(int i, int j, int dep, char[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || arr[i][j] == 0)
            return;
        arr[i][j] = dep;
        help(i + 1, j, dep, grid);
        help(i, j + 1, dep, grid);
        help(i - 1, j, dep, grid);
        help(i, j - 1, dep, grid);
    }
}
