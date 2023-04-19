package com.leiqjl;

/**
 * 1372. Longest ZigZag Path in a Binary Tree - Medium
 */
public class LongestZigZagPathInABinaryTree {
    int res;

    public int longestZigZag(TreeNode root) {
        res = 0;
        dfs(root, 0, -1);
        return res;
    }

    //0-left 1-right
    private void dfs(TreeNode node, int dis, int type) {
        if (node == null) {
            return;
        }
        res = Math.max(res, dis);
        if (node.left != null) {
            dfs(node.left, type == 1 ? dis + 1 : 1, 0);
        }
        if (node.right != null) {
            dfs(node.left, type == 0 ? dis + 1 : 1, 1);
        }
    }
}
