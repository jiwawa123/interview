package com.ji.math;/*
    user ji
    data 2020/2/25
    time 9:43 AM
*/

public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(jc(20));
        System.out.println(trailingZeroes(10));
    }

    public static int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static long jc(int n) {
        long k = 1;
        while (n >= 1) {
            k *= n--;
        }
        System.out.println(k);
        return k;
    }
}
