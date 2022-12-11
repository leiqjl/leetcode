package com.leiqjl;

/**
 * 1339. Maximum Product of Splitted Binary Tree - Medium
 */
public class MaximumProductOfSplittedBinaryTree {
    long result = 0, sum = 0;

    public int maxProduct(TreeNode root) {
        sum = dfs(root);
        dfs(root);
        return (int) (result % (1e9 + 7));
    }

    private long dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        long curSum = cur.val + dfs(cur.left) + dfs(cur.right);
        result = Math.max(result, (sum - curSum) * curSum);
        return curSum;
    }


}
