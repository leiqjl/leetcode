package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 872. Leaf-Similar Trees - Easy
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> s1 = new ArrayDeque<>();
        s1.push(root1);
        Deque<TreeNode> s2 = new ArrayDeque<>();
        s2.push(root2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (dfs(s1) != dfs(s2)) {
                return false;
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }

    private int dfs(Deque<TreeNode> s) {
        while (!s.isEmpty()) {
            TreeNode pop = s.pop();
            if (pop.left == null && pop.right == null) {
                return pop.val;
            }
            if (pop.right != null) {
                s.push(pop.right);
            }
            if (pop.left != null) {
                s.push(pop.left);
            }
        }
        return -1;
    }
}
