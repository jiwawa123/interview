package com.ji.mystring;

/**
 * user ji
 * data 2020/3/11
 * time 9:56 PM
 */
public class MaxLenBathString {
    public static void main(String[] args) {
        System.out.println(lcs("abc", "addbefc"));

    }

    public static int lcs(String a, String b) {
        if (a == null || a.length() == 0)
            return 0;
        if (b == null || b.length() == 0)
            return 0;
        int max = 0;
        int m = a.length();
        int n = b.length();
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int tmp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    tmp += 1;
                }
                dp[i][j] = tmp;
                max = Math.max(max, tmp);
            }
        }


        return max;
    }
}
