package com.leiqjl;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie,
 * from left to right, level by level from leaf to root).
 *
 */
public class BinaryTreeLevelOrderTraversal2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = deque.size();

            while (n > 0) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
                n--;
            }
            result.add(0, list);
        }

        return result;
    }
}
