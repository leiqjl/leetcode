package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 538. Convert BST to Greater Tree - Medium
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * -    Both the left and right subtrees must also be binary search trees.
 */
public class ConvertBSTToGreaterTree {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            convertBST(root.right);
            sum = sum + root.val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }

        // right-root-left
        public TreeNode convertBSTIterative(TreeNode root) {
            if (root == null) {
                return null;
            }
            Deque<TreeNode> s = new ArrayDeque<>();
            int sum = 0;
            TreeNode p = root;
            while (p != null || !s.isEmpty()) {
                if (p != null) {
                    s.push(p);
                    p = p.right;
                } else {
                    p = s.pop();
                    sum = sum + p.val;
                    p.val = sum;
                    p = p.left;
                }
            }
            return root;
        }

}
