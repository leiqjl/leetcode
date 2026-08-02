package com.leiqjl;

/**
 * 486. Predict the Winner - Medium
 *
 */
public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }

    public boolean predictTheWinner1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        int[] nums = {1, 5, 2};
        assert !predictTheWinner.predictTheWinner(nums);
        nums = new int[]{1, 5, 233, 7};
        assert predictTheWinner.predictTheWinner(nums);
    }
}
