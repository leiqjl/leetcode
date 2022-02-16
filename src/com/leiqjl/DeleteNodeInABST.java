package com.leiqjl;

/**
 * 450. Delete Node in a BST - Medium
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *  1.Search for a node to remove.
 *  2.If the node is found, delete the node.
 */
public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode successor = getSuccessor(root.left);
            root.val = successor.val;
            root.left = deleteNode(root.left, root.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    private TreeNode getSuccessor(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

}
