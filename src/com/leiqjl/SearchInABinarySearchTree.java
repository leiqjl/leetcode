package com.leiqjl;

/**
 * 700. Search in a Binary Search Tree - Easy
 * <p>
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }
}
