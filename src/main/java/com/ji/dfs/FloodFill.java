package com.ji.dfs;/*
    user ji
    data 2020/2/26
    time 9:03 AM
*/

public class FloodFill {
    public static void main(String[] args) {

    }

    int arr[][];
    int row;
    int col;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        row = image.length;
        col = image[0].length;
        arr = new int[row][col];
        help(image, sr, sc, image[sr][sc]);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1)
                    image[i][j] = newColor;
            }
        }
        return image;
    }

    public void help(int[][] image, int sr, int sc, int color) {
        if (sc >= color || sc < 0 || sr >= row || sr < 0 || arr[sc][sr] == 1 || image[sc][sr] != color)
            return;
        arr[sc][sr] = 1;
        help(image, sr - 1, sc, color);
        help(image, sr + 1, sc, color);
        help(image, sr, sc - 1, color);
        help(image, sr, sc + 1, color);
    }

}
