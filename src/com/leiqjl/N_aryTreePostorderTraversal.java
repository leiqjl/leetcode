package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal - EASY
 *
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value
 */
public class N_aryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorder(child, result);
        }
        result.add(root.val);
    }

    public List<Integer> postorderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> s = new ArrayDeque<>();
        s.push(root);
        Node p;
        Node pre = null;
        while (!s.isEmpty()) {
            p = s.peek();
            List<Node> children = p.children;
            if ((children == null || children.isEmpty())
                    || (pre != null && children.contains(pre))) {
                s.pop();
                result.add(p.val);
                pre = p;
            } else {
                for (int i = children.size()-1; i >= 0; i--) {
                    s.push(children.get(i));
                }
            }
        }
        return result;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
