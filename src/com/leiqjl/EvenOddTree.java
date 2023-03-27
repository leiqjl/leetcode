package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1609. Even Odd Tree - Medium
 */
public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean even = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int last = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (size-- > 0) {
                TreeNode poll = deque.poll();
                if (even) {
                    if (poll.val % 2 == 0 || poll.val <= last) {
                        return false;
                    }
                } else {
                    if (poll.val % 2 == 1 || poll.val >= last) {
                        return false;
                    }
                }
                last = poll.val;
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            even = !even;
        }
        return true;
    }

}
