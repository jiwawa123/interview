package com.ji.mytree;/*
    user ji
    data 2020/3/7
    time 6:24 PM
*/

import com.ji.util.TreeNode;

import java.util.Stack;

public class BiNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        convertBiNode(root);
    }

    public static TreeNode convertBiNode(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode head = new TreeNode(1);
        TreeNode tmp = head;
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                tmp.right = root;
                tmp = tmp.right;
                root = root.right;
            }
        }
        return head.right;
    }
}
