package com.ji.myarray;

import java.util.Arrays;

/**
 * user ji
 * data 2020/3/27
 * time 8:44 AM
 */
public class HasGroupsSizeX {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 2};
        System.out.println(hasGroupsSizeX(arr));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2)
            return false;
        Arrays.sort(deck);
        int tmp = 0;
        int count = 1;
        int last = deck[0];
        for (int i = 1; i < deck.length; i++) {
            if (last == deck[i]) {
                count++;
            } else {
                if (count < 2)
                    return false;
                tmp = maxFactor(tmp, count);
                if (tmp < 2)
                    return false;
                count = 1;
                last = deck[i];
            }
        }
        tmp = maxFactor(tmp, count);
        return tmp >= 2;
    }

    public static int maxFactor(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        while (min > 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }

        return max;
    }
}
