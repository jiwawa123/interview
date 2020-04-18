package com.ji.money;/*
    user ji
    data 2020/2/11
    time 8:49 PM
*/

public class Years {
    public static void main(String[] args) {
        System.out.println(cal(10, 10, 25, 15));

    }

    public static double cal(int year, double ratio, int base, double ratio1) {
        double money = 35.0;
        for (int i = 0; i < year; i++) {
            money = (money + base * (1 + ratio * 1.0 / 100)) * (1 + ratio1 * 1.0 / 100);
        }
        System.out.println(money);
        return money;
    }


}
