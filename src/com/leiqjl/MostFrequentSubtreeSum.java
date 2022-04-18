package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum - Medium
 * Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
 *
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 */
public class MostFrequentSubtreeSum {

    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                list.add(entry.getKey());
            }
        }
        return  list.stream().mapToInt(i -> i).toArray();
    }
    private int traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = traverse(root.left, map) + traverse(root.right, map) +root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        max = Math.max(max, count);
        return sum;
    }
}
