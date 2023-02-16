package com.leiqjl;

/**
 * 110. Balanced Binary Tree - Easy
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
