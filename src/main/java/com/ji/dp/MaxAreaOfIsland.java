package com.ji.dp;

/**
 * user ji
 * data 2020/3/15
 * time 7:13 PM
 */
public class MaxAreaOfIsland {


    public static void main(String[] args) {

    }

    int max = 0;
    int res = 0;
    boolean flag[][];

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!flag[i][j]) {
                    res = 0;
                    help(i,j,m,n,grid);
                    max = Math.max(res,max);
                }
            }
        }
        return max;
    }

    public void help(int i, int j, int m, int n, int[][] grid) {
        if (i < 0 || j < 0 || j >= n || i >= m || flag[i][j] || grid[i][j] == 0)
            return;
        res += 1;
        flag[i][j] = true;
        help(i + 1, j, m, n, grid);
        help(i - 1, j, m, n, grid);
        help(i, j + 1, m, n, grid);
        help(i, j - 1, m, n, grid);

    }


}
