package com.ji.math;

/**
 * user ji
 * data 2020/3/13
 * time 9:37 AM
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int ugly[] = new int[n];
        ugly[0] = 1;     //基础丑数为1
        int i = 0, j = 0, k = 0;  //初始分别指向三个有序链表第一个元素,这三个有序链表是想象出来的，分别就是ugly数组元素分别乘以2,3,5得到的
        for (int idx = 1; idx < n; idx++) {
            int tmp = Math.min(ugly[i] * 2, Math.min(ugly[j] * 3, ugly[k] * 5));
            //三个链表可能有相同元素，所以只要是最小的，都要移动指针
            if (tmp == ugly[i] * 2) i++;
            if (tmp == ugly[j] * 3) j++;
            if (tmp == ugly[k] * 5) k++;
            ugly[idx] = tmp;
        }
        return ugly[n - 1];
    }
}
