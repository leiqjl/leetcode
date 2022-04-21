package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173. Binary Search Tree Iterator - Medium
 */
public class BinarySearchTreeIterator {
    class BSTIterator {
        Deque<TreeNode> s = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            push(root);
        }

        private void push(TreeNode p) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
        }

        public int next() {
            TreeNode pop = s.pop();
            push(pop.right);
            return pop.val;
        }

        public boolean hasNext() {
            return !s.isEmpty();
        }
    }
}