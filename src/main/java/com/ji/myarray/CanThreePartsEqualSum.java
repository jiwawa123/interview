package com.ji.myarray;

/**
 * user ji
 * data 2020/3/11
 * time 10:15 PM
 */
public class CanThreePartsEqualSum {
    public static void main(String[] args) {
        int arr[] = {18, 12, -18, 18, -19, -1, 10, 10};
        System.out.println(canThreePartsEqualSum(arr));
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int t : A
                ) {
            sum += t;
        }
        if (sum % 3 != 0 || A.length < 3)
            return false;

        int i = 0, j = A.length - 1;
        int f = A[i], l = A[j];
        int average = sum / 3;
        while (i < j) {
            if (average != f) {
                f += A[i + 1];
                i++;
            }
            if (average != l) {
                l += A[j - 1];
                j--;
            }
            if (f == average && l == average)
                break;
        }

        return j - i >= 2;
    }
}
