package com.ji.written.netease;

import java.util.Scanner;

/**
 * user ji
 * data 2020/4/7
 * time 2:28 PM
 */
public class G4 {
    static int max;
    static int res[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        res = new int[m][n];
        for (int i = 0; i < m; i++) {
            String ll = sc.next();
            for (int j = 0; j < ll.length(); j++) {
                res[i][j] = ll.charAt(j)-'0';
            }
        }
        boolean flag[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    max = Integer.MAX_VALUE;
                    help(m,n,arr,i,j,0,flag);
                    res[i][j] = max;
                    flag[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void help(int m, int n, int arr[][], int row, int col, int dep, boolean[][] flag) {
        if (row < 0 || row >= m || col < 0 || col >= n)
            return;
        if (arr[row][col] == 0) {
            max = Math.min(max, dep + 1);
            return;
        }
        if (flag[row][col]) {
            max = Math.min(max, dep + 1 + res[row][col]);
        }
        help(m, n, arr, row - 1, col, dep, flag);
        help(m, n, arr, row, col - 1, dep, flag);
        help(m, n, arr, row + 1, col, dep, flag);
        help(m, n, arr, row, col + 1, dep, flag);
    }

}
