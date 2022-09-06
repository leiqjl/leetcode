package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 637. Average of Levels in Binary Tree - Easy
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int sum = 0;
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = deque.poll();
                sum += poll.val;
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            result.add((double) sum / n);
        }
        return result;
    }

}
