package com.leiqjl;

/**
 * 701. Insert into a Binary Search Tree - Medium
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
 * You can return any of them.
 */
public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
            }
        }
        return root;
    }
}
