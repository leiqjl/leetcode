package com.leiqjl;

/**
 * 129. Sum Root to Leaf Numbers - Medium
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * <p>
 * Each root-to-leaf path in the tree represents a number.
 * <p>
 * - For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * A leaf node is a node with no children.
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return sumNumbers(root.left, val) + sumNumbers(root.right, val);
    }

}
