package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 897. Increasing Order Search Tree - Easy
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only one right child.
 */
public class IncreasingOrderSearchTree {
    // in order
    // left->root->right
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode dummy = new TreeNode(0);
        TreeNode p = root, pre = dummy;
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                p.left = null;
                pre.right = p;

                pre = pre.right;
                p = p.right;
            }
        }
        return dummy.right;
    }

    public TreeNode increasingBST1(TreeNode root) {
        if (root == null) {
            return null;
        }
        return increasingBST(root, null);
    }
    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode head = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root, tail);
        return head;
    }
}
