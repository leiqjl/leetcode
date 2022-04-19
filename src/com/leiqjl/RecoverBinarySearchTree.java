package com.leiqjl;

/**
 * 99. Recover Binary Search Tree - Medium
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {

    // time O(n) space O(1)
    public void recoverTree(TreeNode root) {
        TreeNode p = root, first = null, second = null, pre = null;
        while (p != null) {
            if (p.left != null) {
                TreeNode q = p.left;
                while (q.right != null && q.right != p) {
                    q = q.right;
                }
                if (q.right == null) {
                    q.right = p;
                    p = p.left;
                } else {
                    if (pre != null && pre.val > p.val) {
                        if (first == null) {
                            first = pre;
                        }
                        second = p;
                    }
                    pre = p;
                    q.right = null;
                    p = p.right;
                }
            } else {
                if (pre != null && pre.val > p.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = p;
                }
                pre = p;
                p = p.right;
            }
        }
        if (first != null && second != null) {
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
    }
}
