package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 654. Maximum Binary Tree - Medium
 * <p>
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
 * <p>
 * 1. Create a root node whose value is the maximum value in nums.
 * 2. Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * 3. Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * <p>
 * Return the maximum binary tree built from nums.
 *
 *
 * Constraints:
 *  - 1 <= nums.length <= 1000
 *  - 0 <= nums[i] <= 1000
 *  - All integers in nums are unique.
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int max = Integer.MIN_VALUE, idx = -1;
        for (int i = l; i <= r; i++) {
            if (max < nums[i]) {
                idx = i;
                max = nums[i];
            }
        }
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = constructMaximumBinaryTree(nums, l, idx - 1);
        treeNode.right = constructMaximumBinaryTree(nums, idx + 1, r);
        return treeNode;
    }

    //[3,2,1,6,0,5]
    //[6,3,5,null,2,0,null,null,1]
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        Deque<TreeNode> s = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode cur = new TreeNode(num);
            while (!s.isEmpty() && (s.peek().val < num)) {
                cur.left = s.pop();
            }
            if (!s.isEmpty()) {
                s.peek().right = cur;
            }
            s.push(cur);
        }
        return s.removeLast();
    }
}
