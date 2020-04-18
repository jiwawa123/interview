package com.ji.dp;

/**
 * user ji
 * data 2020/3/20
 * time 1:26 PM
 */
public class LenString {
    public static void main(String[] args) {
        String a = "bsbininm";
        String b = "jmjkbkjkv";
        System.out.println(longestCommonSubsequence(a, b));


    }

    public static int longestCommonSubsequence(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0)
            return 0;
        int m = a.length();
        int n = b.length();
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                } else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 0;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
