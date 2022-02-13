package com.leiqjl;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal - Medium
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Constraints:
 * - 1 <= preorder.length <= 3000
 * - inorder.length == preorder.length
 * - -3000 <= preorder[i], inorder[i] <= 3000
 * - preorder and inorder consist of unique values.
 * - Each value of inorder also appears in preorder.
 * - preorder is guaranteed to be the preorder traversal of the tree.
 * - inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    //preorder  [root, left... , right...]
    //inorder   [left..., root, right...]
    public TreeNode build(int[] preorder, int preLo, int preHi,
                          int[] inorder, int inLo, int inHi) {
        if (preLo > preHi || inLo > inHi) {
            return null;
        }
        int idx = -1;
        TreeNode root = new TreeNode(preorder[preLo]);
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }
        int leftTreeSize = idx - inLo;
        root.left = build(preorder, preLo + 1, preLo + leftTreeSize,
                inorder, inLo, idx - 1);
        root.right = build(preorder, preLo + 1 + leftTreeSize, preHi,
                inorder, idx + 1, inHi);
        return root;
    }
}
