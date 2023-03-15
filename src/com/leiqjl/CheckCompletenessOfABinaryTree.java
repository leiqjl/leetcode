package com.leiqjl;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 958. Check Completeness of a Binary Tree - medium
 */
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll == null) {
                flag = true;
            } else {
                if (flag) {
                    return false;
                }
                deque.offer(poll.left);
                deque.offer(poll.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckCompletenessOfABinaryTree c = new CheckCompletenessOfABinaryTree();
        //Input: root = [1,2,3,4,5,6]
        //Output: true
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        TreeNode root = s.deserializeBFS("1 2 3 4 5 6 X");
        assert c.isCompleteTree(root);

        //Input: root = [1,2,3,4,5,null,7]
        //Output: false
        TreeNode root1 = s.deserializeBFS("1 2 3 4 5 X 7");
        assert !c.isCompleteTree(root1);
    }
}
