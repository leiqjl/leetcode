package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal - Medium
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    //Constraints:
    //
    //1 <= preorder.length <= 30
    //1 <= preorder[i] <= preorder.length
    //All the values of preorder are unique.
    //postorder.length == preorder.length
    //1 <= postorder[i] <= postorder.length
    //All the values of postorder are unique.
    //It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.

    //preorder  [root, left... , right...]
    //postorder  [left... , right..., root]
    //Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    int preIdx = 0, postIdx = 0;
    public TreeNode constructFromPrePost1(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;
        if (root.val != postorder[postIdx]) {
            root.left = constructFromPrePost(preorder, postorder);
        }
        if (root.val != postorder[postIdx]) {
            root.right = constructFromPrePost(preorder, postorder);
        }
        postIdx++;
        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int postIdx = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode p = new TreeNode(preorder[i]);
            while (deque.getLast().val == postorder[postIdx]) {
                deque.pollLast();
                postIdx++;
            }
            if (deque.getLast().left == null) {
                deque.getLast().left = p;
            } else {
                deque.getLast().right = p;
            }
            deque.offer(p);
        }
        return deque.getFirst();
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal c = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        //Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
        //Output: [1,2,3,4,5,6,7]
        TreeNode root = c.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        //Input: preorder = [1], postorder = [1]
        //Output: [1]
    }
}
