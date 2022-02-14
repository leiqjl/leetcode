package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 199. Binary Tree Right Side View - Medium
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 100].
 * - -100 <= Node.val <= 100
 */
public class BinaryTreeRightSideView {

    //         1
    //        / \
    //       2   3      ->   [1,3,4]
    //        \   \
    //         5   4
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int size;
        TreeNode p;
        while (!q.isEmpty()) {
            size = q.size();
            while (size > 0) {
                p = q.remove();
                if (size == 1) {
                    res.add(p.val);
                }
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
                size--;
            }
        }
        return res;
    }

    // right node first
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideViewHelper(root, res, 1);
        return res;
    }

    public void rightSideViewHelper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() < level) {
            res.add(root.val);
        }
        rightSideViewHelper(root.right, res, level + 1);
        rightSideViewHelper(root.left, res, level + 1);
    }
}
