package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBinaryTree {

    //BFS
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 1, size;
        TreeNode p;
        while (!q.isEmpty()) {
            size = q.size();
            while (size-- > 0) {
                p = q.remove();
                if (p.left == null && p.right == null) {
                    return level;
                }
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
            level++;
        }
        return 0;
    }
}
