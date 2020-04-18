package com.ji.written.netease;

import java.util.Scanner;

public class G1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long arr[] = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextLong();
        }
        if(arr[0]>=arr[1]){
            System.out.println(-1);
            return;
        }
        long last = arr[1] -arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                System.out.println(-1);
                return;
            } else {
                last = maxNumber(last, arr[i] - arr[i - 1]);
                if (last == 1) {
                    System.out.println(1);
                    return;
                }
            }

        }
        System.out.println(last);

    }

    static int maxNumber(long m, long n) {
        long temp;
        if (n > m) {
            temp = n;
            n = m;
            m = temp;
        }
        if (m % n == 0) {
            return (int)n;
        }
        return maxNumber(n, m % n);
    }

}
