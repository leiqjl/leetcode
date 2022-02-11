package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 114. Flatten Binary Tree to Linked List
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list
 * and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 *
 *        1
 *       / \
 *      2   5      ->   1-2-3-4-5-6
 *     / \   \
 *    3  4    6
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        node.right = right;
    }

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        TreeNode p, q, pre = null;
        while (!s.isEmpty()) {
            p = s.peek();
            if (p.left == null && p.right == null) {
                s.pop();
                pre = p;
            } else if (pre != null && (pre == p.left || pre == p.right)) {
                TreeNode left = p.left;
                TreeNode right = p.right;
                p.left = null;
                p.right = left;
                q = p;
                while (q.right != null) {
                    q = q.right;
                }
                q.right = right;
                s.pop();
                pre = p;
            } else {
                if (p.left != null) {
                    s.push(p.left);
                }
                if (p.right != null) {
                    s.push(p.right);
                }
            }
        }
    }
}
