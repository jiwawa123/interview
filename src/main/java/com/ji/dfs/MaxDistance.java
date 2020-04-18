package com.ji.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * user ji
 * data 2020/3/29
 * time 9:22 AM
 */
public class MaxDistance {
    public static void main(String[] args) {
        int arr[][] = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(maxDistance(arr));
    }

    //这是一个广搜的问题直接使用 queue保存上一次的结果，每次都向后迭代即可
    public static int maxDistance(int[][] grid) {
        int res = -1;
        int row = grid.length;
        int col = grid[0].length;
        int tmp[][] = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int[] inter = {i, j};
                    queue.add(inter);
                    tmp[i][j] = -1;
                }
            }
        }
        int count = 1;
        while (!queue.isEmpty()) {
            Queue<int[]> que = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] inter = queue.remove();
                int i = inter[0];
                int j = inter[1];
                if (i + 1 < row && grid[i + 1][j] == 0 && tmp[i + 1][j] == 0) {
                    tmp[i + 1][j] = count;
                    res = Math.max(res, count);
                    int t[] = {i + 1, j};
                    que.add(t);
                }

                if (i - 1 >= 0 && grid[i - 1][j] == 0 && tmp[i - 1][j] == 0) {
                    tmp[i - 1][j] = count;
                    res = Math.max(res, count);
                    int t[] = {i - 1, j};
                    que.add(t);
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 0 && tmp[i][j - 1] == 0) {
                    tmp[i][j - 1] = count;
                    res = Math.max(res, count);
                    int t[] = {i, j - 1};
                    que.add(t);
                }
                if (j + 1 < col && grid[i][j + 1] == 0 && tmp[i][j + 1] == 0) {
                    tmp[i][j + 1] = count;
                    res = Math.max(res, count);
                    int t[] = {i, j + 1};
                    que.add(t);
                }

            }
            queue = que;
            count++;
        }


        return res;
    }


}
