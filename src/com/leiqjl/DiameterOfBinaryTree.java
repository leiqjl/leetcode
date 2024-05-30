package com.leiqjl;

/**
 * 543. Diameter of Binary Tree - Easy
 */
public class DiameterOfBinaryTree {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        postorder(root);
        return diameter;
    }
    private int postorder(TreeNode root) {
        if (root == null) return 0;
        int left = postorder(root.left);
        int right = postorder(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
