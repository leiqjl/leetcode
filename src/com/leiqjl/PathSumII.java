package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II - Medium
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, 0, targetSum, path, res);
        return res;
    }
    private void dfs(TreeNode root, int sum, int targetSum,  List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, sum, targetSum, path, res);
        dfs(root.right, sum, targetSum, path, res);
        path.removeLast();
    }
}
