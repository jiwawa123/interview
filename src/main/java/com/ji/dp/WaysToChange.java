package com.ji.dp;

/**
 * user ji
 * data 2020/4/23
 * time 9:03 上午
 */
public class WaysToChange {
    public static void main(String[] args) {
        System.out.println(waysToChange(10));
    }

    /**
     * 这个题目和爬楼梯有不一样的地方在于，爬楼梯涉及排列问题，这个只是用于组合，
     * 使用每次添加一个对象的方式进行计算
     * @param n
     * @return
     */
    public static int waysToChange(int n) {
        if (n < 2)
            return n;
        int max = 1000000007;
        long dp[] = new long[n + 1];
        dp[0] = 1;
        int tmp[] = {1, 5, 10, 25};
        for (int coin : tmp) {
            for (int i = coin; i <= n; ++i) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return (int) dp[n] % max;
    }
}
