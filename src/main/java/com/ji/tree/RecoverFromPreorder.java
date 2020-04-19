package com.ji.tree;

import com.ji.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * user ji
 * data 2020/4/18
 * time 3:18 PM
 */
public class RecoverFromPreorder {
    public static void main(String[] args) {

    }

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0)
            return null;
        List<List<TreeNode>> level = new LinkedList<>();
        int count = 0;
        int dep = 0;
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case '-':
                    if (dep == 0) { // 表示是数字结束
                        TreeNode treeNode = new TreeNode(count);

                    }
                    dep++;
                    break;
                default:
                    count = count * 10 + S.charAt(i) - '0';

            }
        }
        return level.get(0).get(0);
    }
}
