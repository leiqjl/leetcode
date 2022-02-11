package com.leiqjl;

/**
 * 116. Populating Next Right Pointers in Each Node
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersInEachNode {


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNodes(root.left, root.right);
        return root;
    }

    private void connectTwoNodes(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        System.out.println(node1.val + "->" + node2.val);
        System.out.println(node1.val + "->" + node2.val);
        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node2.left, node2.right);

        connectTwoNodes(node1.right, node2.left);
    }

    public Node connect1(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node cur, Node next) {
        if (cur == null) {
            return;
        }
        cur.next = next;
        dfs(cur.left, cur.right);
        dfs(cur.right, cur.next == null ? null : cur.next.left);
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = null, pre = root;
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
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
