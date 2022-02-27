package com.leiqjl;

import java.util.ArrayList;

/**
 * 662. Maximum Width of Binary Tree - Medium
 * <p>
 * Given the root of a binary tree, return the maximum width of the given tree.
 * <p>
 * The maximum width of a tree is the maximum width among all levels.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes are also counted into the length calculation.
 * <p>
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 */
public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        return traversal(root, 0, 1, new ArrayList<>());
    }

    private int traversal(TreeNode root, int level, int index, ArrayList<Integer> starts) {
        if (root == null) {
            return 0;
        }
        if (starts.size() == level) {
            starts.add(index);
        }
        int currVal = index - starts.get(level) + 1;
        int leftVal = traversal(root.left, level + 1, index * 2, starts);
        int rightVal = traversal(root.right, level + 1, index * 2 + 1, starts);
        return Math.max(currVal, Math.max(leftVal, rightVal));
    }
}
