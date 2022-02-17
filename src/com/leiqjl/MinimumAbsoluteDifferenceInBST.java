package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 530. Minimum Absolute Difference in BST - Easy
 *
 * Given the root of a Binary Search Tree (BST),
 * return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 */
public class MinimumAbsoluteDifferenceInBST {

    // inorder BST
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int minDiff = Integer.MAX_VALUE;
        TreeNode p = root, pre = null;
        Deque<TreeNode> s = new ArrayDeque<>();
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                if (pre != null) {
                    minDiff = Math.min(minDiff, Math.abs(p.val - pre.val));
                }
                pre = p;
                p = p.right;
            }
        }
        return minDiff;
    }
}
