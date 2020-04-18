package com.ji.mystring;/*
    user ji
    data 2020/2/22
    time 6:37 PM
*/

import com.ji.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class InsertBit {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.left.left = new TreeNode(5);
        System.out.println(new InsertBit().pathSum(treeNode, 3));
    }

    public static int insertBits(int N, int M, int i, int j) {
        String sn = Integer.toBinaryString(N) + "";
        System.out.println(sn);
        String sm = Integer.toBinaryString(M) + "";
        System.out.println(sm);
        String res = sn.substring(0, Math.max(0, i - 1)) + sm + sn.substring(Math.min(sn.length(), j + 1), sn.length());
        System.out.println(res);
        return Integer.parseInt(res, 2);
    }

    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return count;
    }

    public void dfs(TreeNode root, int sum) {
        if (root != null) {
            dfsSum(root, sum);
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }

    public void dfsSum(TreeNode root, int sum) {
        if (root == null)
            return;
        if (sum == root.val)
            count++;
        dfsSum(root.left, sum - root.val);
        dfsSum(root.right, sum - root.val);
    }
}
