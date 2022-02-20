package com.leiqjl;

/**
 * 1373. Maximum Sum BST in Binary Tree - Hard
 * <p>
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 */
public class MaximumSumBSTInBinaryTree {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        inorder(root);
        return maxSum;
    }


    /**
     * res[0] sum
     * res[1] min value
     * res[2] max value
     */
    private int[] inorder(TreeNode root) {
        if (root == null) {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] res = new int[3];
        int[] l = inorder(root.left);
        int[] r = inorder(root.right);
        if (l != null && r != null &&
                root.val > l[2] && root.val < r[1]) {
            res[0] = l[0] + r[0] + root.val;
            res[1] = Math.min(l[1], root.val);
            res[2] = Math.max(r[2], root.val);
            if (res[0] > maxSum) {
                maxSum = res[0];
            }
            return res;
        } else {
            return null;
        }
    }
}
