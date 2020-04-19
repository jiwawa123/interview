package com.ji.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * user ji
 * data 2020/4/18
 * time 9:39 AM
 */
public class MinFallingPathSum {
    public static void main(String[] args) {

    }

    public int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m][n];
        int res = Integer.MAX_VALUE;
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<int[]> next = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                }else{
                    dp[i][j] = arr[i][j] + findMin(tmp,j);
                }
                int[] inter = {j, dp[i][j]};
                next.add(inter);

            }
            Collections.sort(next, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            tmp = next;
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res,dp[m-1][i]);
        }
        return res;
    }

    private int findMin(List<int[]> tmp, int i) {
        int res = 0;
        for (int j = 0; j < tmp.size(); j++) {
            if(tmp.get(j)[0]!=i){
                res = tmp.get(j)[1];
                break;
            }
        }
        return res;
    }
}
