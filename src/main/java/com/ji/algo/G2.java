package com.ji.algo;/*
    user ji
    data 2019/10/26
    time 3:22 PM
*/

import com.ji.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class G2 {
    public static void main(String[] args) {

    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int count = 0;
            Queue<TreeNode> tmp = new LinkedList<>();
            boolean flag = true;
            while (!queue.isEmpty()) {
                if (level > max) {
                    return false;
                }
                count++;
                TreeNode t = queue.remove();
                if (!flag) {
                    if (t.left != null)
                        return false;
                    if (t.right != null)
                        return false;
                }
                if (t.left == null && t.right != null)
                    return false;
                if (t.left != null) {
                    tmp.add(t.left);
                } else {
                    flag = false;
                }
                if (t.right != null) {
                    tmp.add(t.right);
                } else {
                    flag = false;
                }
            }
            if ((int) Math.pow(2, level++) == count) {
                max++;
            }
            queue = tmp;
        }
        return true;
    }
}
