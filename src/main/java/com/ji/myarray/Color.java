package com.ji.myarray;

/**
 * user ji
 * data 2020/3/27
 * time 8:30 PM
 */
public class Color {
    public static void main(String[] args) {
        int arr[] ={2,5,3,1,3,2,4,1,0,5,4,3};
//        System.out.println(5,arr);
    }

    public static int getMinLen(int len, int[] arr) {
        int res = -1;
        int tmp = 0;
        int flag[] = new int[len + 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] > 0 && flag[arr[i]] > 0) {
                tmp++;
            }

            flag[arr[i]]++;
            if (tmp == len) {
                while (j <= i && (arr[i] != 0 || flag[arr[j]] > 1)) {
                    flag[arr[j]]--;
                    j++;
                }
                if (res == -1 || res > i - j + 1) {
                    res = i - j + 1;
                }
            }
        }
        return res;
    }
}
