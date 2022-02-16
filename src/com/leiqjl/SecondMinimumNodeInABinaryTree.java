package com.leiqjl;

/**
 * 671. Second Minimum Node In a Binary Tree - Easy
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node.
 * If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 * More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 */
public class SecondMinimumNodeInABinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        // root.val = min(root.left.val, root.right.val)
        int left;
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        } else {
            left = root.left.val;
        }
        int right;
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);;
        } else {
            right = root.right.val;
        }

        return (left == -1 || right == -1) ? Math.max(left, right) : Math.min(left, right);
    }
}
