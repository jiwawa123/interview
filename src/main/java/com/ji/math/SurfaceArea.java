package com.ji.math;

/**
 * user ji
 * data 2020/3/25
 * time 9:00 AM
 */
public class SurfaceArea {
    public static void main(String[] args) {
        int arr[][] = {{1,2},{3,4}};
        System.out.println(surfaceArea(arr));
    }

    public static int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                res += 2;
                res += i > 0 ? Math.max(0, grid[i][j] - grid[i - 1][j]) : grid[i][j];
                res += i < grid.length - 1 ? Math.max(0, grid[i][j] - grid[i + 1][j]) : grid[i][j];
                res += j > 0 ? Math.max(0, grid[i][j] - grid[i][j - 1]) : grid[i][j];
                res += j < grid[0].length - 1 ? Math.max(0, grid[i][j] - grid[i][j + 1]) : grid[i][j];

            }
        }

        return res;
    }
}
