package com.leiqjl;

/**
 * 124. Binary Tree Maximum Path Sum - Hard
 * <p>
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode s) {
        if (s == null) {
            return 0;
        }
        int maxLeft = dfs(s.left);
        int maxRight = dfs(s.right);
        int curMax = Math.max(s.val, Math.max(maxLeft, maxRight) + s.val);
        max = Math.max(max, Math.max(curMax, s.val + maxLeft + maxRight));
        return curMax;
    }
}
