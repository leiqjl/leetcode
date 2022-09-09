package com.leiqjl;

/**
 * 1448. Count Good Nodes in Binary Tree - Medium
 */
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= val) {
            count = 1;
            val = root.val;
        }
        return count + countGoodNodes(root.left, val) + countGoodNodes(root.right, val);
    }
}
