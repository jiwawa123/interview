package com.ji.math;

/**
 * user ji
 * data 2020/3/18
 * time 8:53 AM
 */
public class IsRectangleOverlap {
    public static void main(String[] args) {

    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }
}
