package com.ji.dp;

/**
 * user ji
 * data 2020/3/14
 * time 7:36 PM
 */
public class LR {
    public static void main(String[] args) {

    }

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }


        return dp[m - 1][n - 1];
    }
}
