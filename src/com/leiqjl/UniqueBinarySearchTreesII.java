package com.leiqjl;

import java.util.LinkedList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II - Medium
 * <p>
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n.
 * Return the answer in any order.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTrees = generateTrees(low, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, high);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }

        }
        return res;
    }


    //dp

    public List<TreeNode> generateTreesDP(int n) {
        LinkedList<TreeNode>[] dp = new LinkedList[n + 1];
        dp[0] = new LinkedList<>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        for (int len = 1; len <= n; len++) {
            dp[len] = new LinkedList<>();
            //root
            for (int i = 1; i <= len; i++) {
                for (TreeNode leftTree : dp[i - 1]) {
                    for (TreeNode rightTree: dp[len - i]) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = clone(rightTree, i);
                        dp[len].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode root = new TreeNode(n.val+offset);
        root.left = clone(n.left, offset);
        root.right = clone(n.right, offset);
        return root;
    }
}
