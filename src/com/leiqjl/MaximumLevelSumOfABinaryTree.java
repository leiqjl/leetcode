package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1161. Maximum Level Sum of a Binary Tree - Medium
 */
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 1, minLevel = 1, maxSum = Integer.MIN_VALUE;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int sum = 0;
            while (size > 0) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
                sum += poll.val;
                size--;
            }
            if (sum > maxSum) {
                maxSum = sum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
    }
}
