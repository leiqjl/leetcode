package com.leiqjl;

/**
 *
 * 1022. Sum of Root To Leaf Binary Numbers - Easy
 *
 * You are given the root of a binary tree where each node has a value 0 or 1.
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 *
 * - For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
 *
 * The test cases are generated so that the answer fits in a 32-bits integer.
 */
public class SumOfRootToLeafBinaryNumbers {

    /**
     *        1
     *      /  \
     *     0    1
     *    / \  / \
     *   0  1 0   1
     *   (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     */
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        if (root.left == root.right) {
            return val;
        }
        return dfs(root.left, val)+dfs(root.right, val);
    }


}
