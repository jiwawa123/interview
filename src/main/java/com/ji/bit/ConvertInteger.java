package com.ji.bit;/*
    user ji
    data 2020/2/24
    time 7:06 PM
*/

import java.util.ArrayList;
import java.util.List;

public class ConvertInteger {
    public static void main(String[] args) {
        System.out.println(reverseBits(1096063));
    }

    public int convertInteger(int A, int B) {
        String a = Integer.toBinaryString(A);
        String b = Integer.toBinaryString(B);
        int i = a.length() - 1;
        int j = b.length() - 1;
        int cnt = 0;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i--) != b.charAt(j--)) {
                cnt++;
            }
        }
        while (i >= 0) {
            if (a.charAt(i--) != '0') {
                cnt++;
            }
        }
        while (j >= 0) {
            if (b.charAt(j--) != '0') {
                cnt++;
            }
        }

        return cnt;
    }

    public static int reverseBits(int num) {

        int max = 0;
        int f = 0;
        int s = 0;
        char tmp[] = Long.toBinaryString(num).toCharArray();
        System.out.println(String.valueOf(tmp));
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == '1') {
                f++;
            } else {
                max = Math.max(s + f + 1, max);
                s = f;
                f = 0;
            }
        }
        if(s!=0){
            max = Math.max(f+s+1,max);
        }
        max = Math.max(f + 1, max);
        return max;

    }
}
