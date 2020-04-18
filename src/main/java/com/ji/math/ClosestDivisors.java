package com.ji.math;

/**
 * user ji
 * data 2020/3/20
 * time 12:30 PM
 */
public class ClosestDivisors {
    public static void main(String[] args) {

    }

    public int[] closestDivisors(int num) {
        int num1 = num + 1;
        int num2 = num + 2;
        int min = Integer.MAX_VALUE;
        int res[] = new int[2];
        for (int i = 1; i <= num2 / 2; i++) {
            if (num1 % i == 0) {
                if (min > Math.abs(num1 / i - i)) {
                    min = Math.abs(num1 / i - i);
                    res[0] = res[i];
                    res[1] = res[num1 / i];
                }
            }
//            if (num2 % i == 0) {
//                if (min > Math.abs(num2 / i - i)) {
//                    min = Math.abs(num2 / i - i);
//                    res[0] = res[i];
//                    res[1] = res[num2 / i];
//                }
//            }
        }

        return res;
    }
}
