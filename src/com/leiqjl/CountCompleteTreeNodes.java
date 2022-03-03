package com.leiqjl;

/**
 * 222. Count Complete Tree Nodes - Medium
 */
public class CountCompleteTreeNodes {

    //O( (logN)^2 )
    public int countNodes(TreeNode root) {
        int count = 0, h = height(root);
        while (root != null) {
            // left subtree: perfect binary tree
            if (height(root.right) == h - 1) {
                root = root.right;
                count += 1 << (h - 1);
            } else {
                root = root.left;
                count += 1 << (h - 2);
            }
            h--;
        }
        return count;
    }

    private int height(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    //perfect binary tree hl==hr
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = 0, hr = 0;
        TreeNode l = root, r = root;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        if (hl == hr) {
            return (int) (Math.pow(2, hl)) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
