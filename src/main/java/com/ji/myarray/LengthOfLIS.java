package com.ji.myarray;

/**
 * user ji
 * data 2020/3/14
 * time 7:00 PM
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int arr[] = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(arr));
    }


    public static int lengthOfLIS(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 2)
            return nums.length;
        int arr[] = new int[nums.length];
        int max = 1;
        arr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int len = 1;
            for (int j = i-1; j >=0 ; j--) {
                if(nums[i]>=nums[j]){
                    len = Math.max(len,arr[j]);
                }
            }
            arr[i] = len;
            max = Math.max(max,arr[i]);
        }


        return max;
    }
}
