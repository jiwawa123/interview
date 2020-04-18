package com.ji.myarray;/*
    user ji
    data 2020/2/25
    time 9:16 AM
*/

import java.util.Map;
import java.util.TreeMap;

public class MaxAliveYear {
    public static void main(String[] args) {
        int a[] = {1900};
        int b[] = {1901};
        System.out.println(maxAliveYearII(a,b));
    }

    public int maxAliveYear(int[] birth, int[] death) {
        int arr[] = new int[1001];
        for (int i = 0; i < birth.length; i++) {
            for (int j = birth[i] - 1900; j < death[i] - 1900; j++) {
                arr[j] += 1;
            }
        }
        int max = 0, year =1900;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
                year = 1900+i;
            }
        }
        return year;
    }

    public static int maxAliveYearII(int[] birth, int[] death) {
        int[] changes = new int[102];
        int[] alive = new int[101];
        int n = birth.length;
        for (int i = 0; i < n; i++) {
            changes[birth[i] - 1900]++;
            changes[death[i] - 1899]--;
        }
        int max = 0, res = 1900;
        for (int i = 1; i < 101; i++) {
            alive[i] = alive[i - 1] + changes[i];
            if (alive[i] > max) {
                max = alive[i];
                res = 1900 + i;
            }
        }
        return res;
    }
}
