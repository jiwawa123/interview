package com.ji.mytree;/*
    user ji
    data 2020/3/2
    time 10:17 AM
*/

import com.ji.util.TreeNode;

import java.util.Arrays;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int arr[] = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(arr).val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        int med = nums.length / 2;
        TreeNode root = new TreeNode(nums[med]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, Math.max(0, med)));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, med + 1, nums.length));
        return root;
    }
}
