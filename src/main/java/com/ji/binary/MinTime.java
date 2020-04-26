package com.ji.binary;

/**
 * user ji
 * data 2020/4/26
 * time 4:37 下午
 */
public class MinTime {

    //leetcode 410 变形，直接通过二分查找，使用贪心考虑附加的人处理任务的事情
    public int minTime(int[] time, int m) {
        int n = time.length;
        if (n <= m) return 0;
        int sum = 0;
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isOk(time, mid, m)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public boolean isOk(int[] time, int k, int m) {
        int max = 0;
        int sum = 0;
        int n = time.length;
        for (int i = 0; i < n; i++) {
            if (m == 0) return false;
            if (max < time[i]) max = time[i];
            sum += time[i];
            if (sum - max > k) {
                i--;
                max = 0;
                m--;
                sum = 0;
            }
        }
        return true;
    }
}
