package com.leiqjl;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal - Medium
 * <p>
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
 * postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Constraints:
 * - 1 <= inorder.length <= 3000
 * - postorder.length == inorder.length
 * - -3000 <= inorder[i], postorder[i] <= 3000
 * - inorder and postorder consist of unique values.
 * - Each value of postorder also appears in inorder.
 * - inorder is guaranteed to be the preorder traversal of the tree.
 * - postorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    //inorder   [left..., root, right...]
    //postorder  [left... , right..., root]
    public TreeNode build(int[] inorder, int inLo, int inHi,
                          int[] postorder, int postLo, int postHi) {
        if (postLo > postHi || inLo > inHi) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postHi]);
        int idx = -1;
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }
        int leftSize = idx - inLo;
        root.left = build(inorder, inLo, idx - 1,
                postorder, postLo, postLo + leftSize - 1);
        root.right = build(inorder, idx + 1, inHi,
                postorder, postLo + leftSize, postHi - 1);
        return root;
    }
}
