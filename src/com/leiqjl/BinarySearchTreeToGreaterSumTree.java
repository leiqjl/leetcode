package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1038. Binary Search Tree to Greater Sum Tree - Medium
 */
public class BinarySearchTreeToGreaterSumTree {

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        sum = sum + root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }

    // right-root-left
    public TreeNode bstToGstIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> s = new ArrayDeque<>();
        int sum = 0;
        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.right;
            } else {
                p = s.pop();
                sum = sum + p.val;
                p.val = sum;
                p = p.left;
            }
        }
        return root;
    }
}
