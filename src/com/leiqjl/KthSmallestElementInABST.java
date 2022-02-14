package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 230. Kth Smallest Element in a BST - Medium
 *
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Constraints:
 * - The number of nodes in the tree is n.
 * - 1 <= k <= n <= 104
 * - 0 <= Node.val <= 104
 */
public class KthSmallestElementInABST {

    int res = -1;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        traverse(root.right);
    }

    //inorder iterative
    public int kthSmallest1(TreeNode root, int k) {
        int res = -1;
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                k--;
                if (k == 0) {
                    res = p.val;
                    return res;
                }
                p = p.right;
            }
        }
        return res;
    }

}
