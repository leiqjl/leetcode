package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        TreeNode p, pre = null;
        while (!s.isEmpty()) {
            p = s.peek();
            if ((p.left == null && p.right == null)
                    || pre != null && (pre == p.left || pre == p.right)) {
                s.pop();
                result.add(p.val);
                pre = p;
            } else {
                if (p.right != null) {
                    s.push(p.right);
                }
                if (p.left != null) {
                    s.push(p.left);
                }
            }
        }
        return result;
    }
}
