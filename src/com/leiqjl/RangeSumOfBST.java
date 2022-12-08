package com.leiqjl;

/**
 * 938. Range Sum of BST - Easy
 */
public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
    }
}
