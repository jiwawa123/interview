package com.ji.tree;

import com.ji.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * user ji
 * data 2020/4/18
 * time 2:53 PM
 */
public class SufficientSubset {
    public static void main(String[] args) {

    }

    Map<TreeNode, Integer> map = new HashMap<>();

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null)
            return root;
        preOrder(root, 0);
        return help(root, limit);
    }

    //遍历找到所有的前缀和
    public void preOrder(TreeNode root, int tmp) {
        if (root == null)
            return;
        tmp += root.val;
        map.put(root, tmp);
        preOrder(root.left, tmp);
        preOrder(root.right, tmp);
    }


    public TreeNode help(TreeNode root, int limit) {
        if (root == null)
            return null;
        // 叶子节点
        if (root.left == null && root.right == null && map.get(root) < limit) {
            return null;
        }
        TreeNode tmpL = root.left;
        TreeNode tmpR = root.right;
        root.left = help(root.left, limit);
        root.right = help(root.right, limit);
        if (root.left == null && root.right == null && map.get(root) < limit) {
            return null;
        }
        if ((tmpL != null || tmpR != null) && root.left == null && root.right == null)
            return null;
        return root;
    }
}
