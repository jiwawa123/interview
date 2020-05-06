package com.ji.dp;

/**
 * user ji
 * data 2020/5/6
 * time 8:17 上午
 */
public class MincostTickets {
    public static void main(String[] args) {

    }

    // dp 问题 类似于 书桌问题，从后往前推导即可
    public int mincostTickets(int[] days, int[] costs) {
        int last = days[days.length - 1];
        int dp[] = new int[last + 1];
        dp[0] = 0;
        int i = 1, j = 0;
        while (i <= last) {
            if (i == days[j]) {
                int min = Integer.MAX_VALUE;
                if (i - 7 >= 0) {
                    min = Math.min(dp[i - 7] + costs[1], min);
                } else {
                    min = Math.min(0 + costs[1], min);
                }
                if (i - 1 >= 0) {
                    min = Math.min(dp[i - 1] + costs[0], min);
                }else{
                    min = Math.min(costs[0], min);
                }
                if (i - 30 >= 0) {
                    min = Math.min(dp[i - 30] + costs[2], min);
                }else{
                    min = Math.min(costs[2],min);
                }
                dp[i] = min;
                j++;
            } else {
                dp[i] = dp[i - 1];
            }
            i++;
        }
        return dp[last];
    }
}
