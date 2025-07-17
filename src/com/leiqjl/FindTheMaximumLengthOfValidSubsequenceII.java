package com.leiqjl;

/**
 * 3202. Find the Maximum Length of Valid Subsequence II - Medium
 */
public class FindTheMaximumLengthOfValidSubsequenceII {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int ans = 0;
        for (int i : nums) {
            i %= k;
            for (int j = 0; j < k; j++) {
                dp[j][i] = dp[i][j] + 1;
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheMaximumLengthOfValidSubsequenceII f = new FindTheMaximumLengthOfValidSubsequenceII();
        assert f.maximumLength(new int[]{1, 2, 3, 4, 5}, 2) == 5;
        assert f.maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3) == 4;
    }
}
