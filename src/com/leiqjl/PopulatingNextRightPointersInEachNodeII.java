package com.leiqjl;

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




    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node dummyHead = new Node(-1);
        Node p = dummyHead, cur = root;
        while (cur != null) {
            if (cur.left != null) {
                p.next = cur.left;
                p = p.next;
            }
            if (cur.right != null) {
                p.next = cur.right;
                p = p.next;
            }
            if (cur.next != null) {
                cur = cur.next;
            } else {
                //next level
                cur = dummyHead.next;
                dummyHead.next = null;
                p = dummyHead;
            }
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
