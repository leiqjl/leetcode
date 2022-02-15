package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal - EASY
 *
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value
 */
public class N_aryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node child : root.children) {
            preorder(child, result);
        }
    }

    public List<Integer> preorderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> s = new ArrayDeque<>();
        s.push(root);
        Node p;
        while (!s.isEmpty()) {
            p = s.pop();
            result.add(p.val);
            List<Node> children = p.children;
            if (children != null && !children.isEmpty()) {
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
