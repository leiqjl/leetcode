package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 429. N-ary Tree Level Order Traversal - MEDIUM
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value
 */
public class N_aryTreeLevelTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        int size;
        List<Integer> list;
        Node p;
        while (!q.isEmpty()) {
            size = q.size();
            list = new ArrayList<>();
            while (size > 0) {
                p = q.remove();
                list.add(p.val);
                if (p.children != null && !p.children.isEmpty()) {
                    q.addAll(p.children);
                }
                size--;
            }
            result.add(list);
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
