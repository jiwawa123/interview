package com.ji.dp;

/**
 * user ji
 * data 2020/4/18
 * time 8:53 AM
 */
public class MaxArea {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int count = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] > height[j]) {
                count = Math.max((j - i) * height[j], count);
                j--;
            }else{
                count = Math.max((j - i) * height[i], count);
                i++;
            }
        }

        return count;
    }
}
