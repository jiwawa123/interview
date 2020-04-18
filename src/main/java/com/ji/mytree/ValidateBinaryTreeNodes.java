package com.ji.mytree;/*
    user ji
    data 2020/3/2
    time 4:32 PM
*/

import java.util.Arrays;

public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
        int l[] = {1, -1, -1, 4, -1, -1};
        int r[] = {2, -1, -1, 5, -1, -1};
        System.out.println(validateBinaryTreeNodes(6, l, r));
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                arr[leftChild[i]] += 1;
                if (leftChild[leftChild[i]] == i || rightChild[leftChild[i]] == i)
                    return false;
                if (arr[leftChild[i]] > 0)
                    return false;
            }

            if (rightChild[i] != -1) {
                arr[rightChild[i]] += 1;
                if (leftChild[rightChild[i]] == i || rightChild[rightChild[i]] == i)
                    if (arr[rightChild[i]] > 0)
                        return false;
            }

        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1)
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }
}
