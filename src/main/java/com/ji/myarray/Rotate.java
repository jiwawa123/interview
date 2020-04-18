package com.ji.myarray;

/**
 * user ji
 * data 2020/4/7
 * time 8:48 AM
 */
public class Rotate {
    public static void main(String[] args) {

    }

    // 找到相应的规律即可
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //每次行遍历，交换左右即可
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
        //每次对角遍历，上下交换即可
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = temp;
            }
        }
    }
}
