package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal - EASY
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        TreeNode p;
        while (!s.isEmpty()) {
            p = s.pop();
            result.add(p.val);
            if (p.right != null) {
                s.push(p.right);
            }
            if (p.left != null) {
                s.push(p.left);
            }
        }
        return result;
    }
}
