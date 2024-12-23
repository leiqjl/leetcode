package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 2471. Minimum Number of Operations to Sort a Binary Tree by Level - Medium
 */
public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    //Constraints:
    //
    //The number of nodes in the tree is in the range [1, 10^5].
    //1 <= Node.val <= 10^5
    //All the values of the tree are unique.
    public int minimumOperations(TreeNode root) {
        int count = 0;
        int mask = 0xFFFF;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long[] arr = new long[size];
            for (int i = 0; i < size; i++) {
                TreeNode p = q.remove();
                arr[i] = (i & mask) | (long) p.val << 17;
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
            Arrays.sort(arr);
            for (int i = 0; i < size; i++) {
                int pos = (int) (arr[i] & mask);
                if (pos != i) {
                    long temp = arr[i];
                    arr[i] = arr[pos];
                    arr[pos] = temp;
                    count++;
                    i--;
                }
            }
        }
        return count;
    }
}
