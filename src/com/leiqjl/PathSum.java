package com.leiqjl;

/**
 * 112. Path Sum - Easy
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum, targetSum) || hasPathSum(root.right, sum, targetSum);
    }
}
