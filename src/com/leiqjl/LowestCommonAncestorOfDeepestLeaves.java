package com.leiqjl;

/**
 * 1123. Lowest Common Ancestor of Deepest Leaves - Medium
 */
public class LowestCommonAncestorOfDeepestLeaves {
    class DepthTreeNode {
        int depth;
        TreeNode treeNode;

        public DepthTreeNode(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).treeNode;
    }

    private DepthTreeNode dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return new DepthTreeNode(null, 0);
        }
        DepthTreeNode left = dfs(treeNode.left);
        DepthTreeNode right = dfs(treeNode.right);
        if (left.depth > right.depth) {
            return new DepthTreeNode(left.treeNode, left.depth + 1);
        } else if (left.depth < right.depth) {
            return new DepthTreeNode(right.treeNode, right.depth + 1);
        } else {
            return new DepthTreeNode(treeNode, left.depth + 1);
        }
    }
}
