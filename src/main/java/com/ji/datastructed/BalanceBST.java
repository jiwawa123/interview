package com.ji.datastructed;

import com.ji.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * user ji
 * data 2020/3/15
 * time 10:30 PM
 */
public class BalanceBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode res = new BalanceBST().balanceBST(root);
        System.out.println(res.val);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return build(arr);
    }

    public TreeNode build(int arr[]) {
        if (arr.length == 0)
            return null;
        int med = arr.length / 2;
        TreeNode root = new TreeNode(arr[med]);
        root.left = build(Arrays.copyOfRange(arr, 0, med));
        root.right = build(Arrays.copyOfRange(arr, med + 1, arr.length));
        return root;
    }
}
