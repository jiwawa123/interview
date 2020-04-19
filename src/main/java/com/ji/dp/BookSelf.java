package com.ji.dp;

import java.util.Arrays;

/**
 * user ji
 * data 2020/4/18
 * time 1:38 PM
 */
public class BookSelf {
    public static void main(String[] args) {

    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int eachwidth = 0;
            int h = 0;
            //j是书本books数组的索引，譬如当i=2，表示前2本书，那么对应books就是books[0],books[1]的情况
            for (int j = i - 1; j >= 0; j--) {
                eachwidth += books[j][0];
                if (eachwidth > shelf_width) {
                    break;
                }
                h = Math.max(h, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + h);
            }
        }
        return dp[books.length];
    }
}
