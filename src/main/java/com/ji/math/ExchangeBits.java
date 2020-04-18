package com.ji.math;/*
    user ji
    data 2020/3/2
    time 9:30 AM
*/

public class ExchangeBits {
    public static void main(String[] args) {
        System.out.println(exchangeBits(1));
    }

    public static int exchangeBits(int num) {
        String tmp = Integer.toBinaryString(num);
        if (tmp.length() % 2 != 0) {
            tmp = '0' + tmp;
        }
        char t[] = tmp.toCharArray();
        for (int i = t.length - 1; i >= 1; i -= 2) {
            char m = t[i];
            t[i] = t[i - 1];
            t[i - 1] = m;
        }
        return Integer.parseInt(String.valueOf(t), 2);
    }
}
