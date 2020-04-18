package com.ji.search;

/**
 * user ji
 * data 2020/3/17
 * time 9:23 PM
 */
public class Search {
    public static void main(String[] args) {

    }

    public int search(int[] arr, int target) {
        for (int k = 0; k < arr.length; k++) {
            if(arr[k]==target)
                return k;
        }

        return -1;
    }
}
