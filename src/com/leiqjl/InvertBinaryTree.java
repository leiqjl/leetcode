package com.leiqjl;

import java.util.LinkedList;

/**
 * 226. Invert Binary Tree - EASY
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return root;
    }
}
