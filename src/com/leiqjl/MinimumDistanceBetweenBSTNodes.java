package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 783. Minimum Distance Between BST Nodes - Easy
 * Given the root of a Binary Search Tree (BST),
 * return the minimum difference between the values of any two different nodes in the tree.
 */
public class MinimumDistanceBetweenBSTNodes {
    //The number of nodes in the tree is in the range [2, 100].
    //0 <= Node.val <= 10^5
    //left-root-right
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root, pre = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (pre != null) {
                    min = Math.min(min, Math.abs(p.val - pre.val));
                }
                pre = p;
                p = p.right;
            }
        }
        return min;
    }
}
