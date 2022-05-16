package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1302. Deepest Leaves Sum - Medium
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            sum = 0;
            int size = q.size();
            while (size > 0) {
                TreeNode poll = q.poll();
                sum += poll.val;
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
                size--;
            }
        }
        return sum;
    }
}
