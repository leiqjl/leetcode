package com.leiqjl;

/**
 * 96. Unique Binary Search Trees - Medium
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] mem = new int[n + 1];
        mem[0] = 1;
        mem[1] = 0;
        return count(n, mem);
    }

    public int count(int n, int[] mem) {
        if (mem[n] > 0) {
            return mem[n];
        }
        int l, r, res = 0;
        for (int i = 1; i <= n; i++) {
            l = count(i - 1, mem);
            r = count(n - i, mem);
            res = res + l * r;
        }
        mem[n] = res;
        return res;
    }

    //dp
    //dp[n] = dp[0]*dp[n-1]+dp[1]*dp[n-2] +...+dp[n-1]*dp[0]; dp[i-1]*dp[n-i]
    public int numTrees1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
