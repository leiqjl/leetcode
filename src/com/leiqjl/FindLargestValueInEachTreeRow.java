package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 515. Find Largest Value in Each Tree Row - Medium
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode poll = q.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
                size--;
            }
            result.add(max);
        }
        return result;
    }
}
