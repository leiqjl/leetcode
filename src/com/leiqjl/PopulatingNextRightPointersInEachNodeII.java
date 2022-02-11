package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 *
 * Follow-up:
 *  - You may only use constant extra space.
 *  - The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNodeII {


    //todo  constant extra space
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int size;
        Node cur, pre = null;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0) {
                cur = queue.remove();
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                size--;
            }
            pre = null;
        }
        return root;
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
