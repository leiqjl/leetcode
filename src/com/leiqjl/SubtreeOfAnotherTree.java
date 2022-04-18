package com.leiqjl;

/**
 * 572. Subtree of Another Tree - Easy
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSame(root, subRoot) || (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && (isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right));
    }
}
