package com.leiqjl;

/**
 * 606. Construct String from Binary Tree - Easy
 */
public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String str = String.valueOf(root.val);
        if (root.left != null && root.right != null) {
            str = str + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
        } else if (root.left != null) {
            str = str + "(" + tree2str(root.left) + ")";
        } else if (root.right != null) {
            str = str + "(" + ")" + "(" + tree2str(root.right) + ")";
        }
        return str;
    }
}
