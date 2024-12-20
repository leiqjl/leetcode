package com.leiqjl;

/**
 * 2415. Reverse Odd Levels of Binary Tree - Medium
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 * <p>
 * ·For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
 * Return the root of the reversed tree.
 * <p>
 * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
 * <p>
 * The level of a node is the number of edges along the path between it and the root node.
 */
public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverse(root.left, root.right, true);
        return root;
    }

    private void reverse(TreeNode leftNode, TreeNode rightNode, boolean isOddLevel) {
        if (leftNode == null || rightNode == null) {
            return;
        }
        if (isOddLevel) {
            int tmp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = tmp;
        }
        reverse(leftNode.left, rightNode.right, !isOddLevel);
        reverse(leftNode.right, rightNode.left, !isOddLevel);
    }

    public static void main(String[] args) {
        ReverseOddLevelsOfBinaryTree r = new ReverseOddLevelsOfBinaryTree();
        // Input: root = [2,3,5,8,13,21,34]

        TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(8), new TreeNode(13)), new TreeNode(5, new TreeNode(21), new TreeNode(34)));
        TreeNode result = r.reverseOddLevels(root);
        // Input: root = [7,13,11]
        TreeNode root1 = new TreeNode(7, new TreeNode(13), new TreeNode(11));
        TreeNode reverse = r.reverseOddLevels(root1);
    }

}
