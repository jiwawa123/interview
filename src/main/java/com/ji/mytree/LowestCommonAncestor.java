package com.ji.mytree;/*
    user ji
    data 2020/3/2
    time 9:58 AM
*/

import com.ji.util.TreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val)
            return root;
        if (isExist(root.left, p) && isExist(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (isExist(root.right, p) && isExist(root.right, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public boolean isExist(TreeNode root, TreeNode p) {
        if (root == null)
            return false;
        if (root.val == p.val)
            return true;
        return isExist(root.left, p) || isExist(root.right, p);
    }
}
