package com.leiqjl;

/**
 * 865.Smallest Subtree with all the Deepest Nodes - Medium
 * Given the root of a binary tree, the depth of each node is the shortest distance to the root.
 *
 * Return the smallest subtree such that it contains all the deepest nodes in the original tree.
 *
 * A node is called the deepest if it has the largest depth possible among any node in the entire tree.
 *
 * The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private DepthTreeNode dfs(TreeNode root) {
        if (root == null) {
            return new DepthTreeNode(null, 0);
        }
        DepthTreeNode left = dfs(root.left);
        DepthTreeNode right = dfs(root.right);
        if (left.distance > right.distance) {
            return new DepthTreeNode(left.node, left.distance + 1);
        } else if (right.distance > left.distance) {
            return new DepthTreeNode(right.node, right.distance + 1);
        } else {
            return new DepthTreeNode(root, left.distance + 1);
        }
    }


}
class DepthTreeNode {
    TreeNode node;
    int distance;
    public DepthTreeNode(TreeNode node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
