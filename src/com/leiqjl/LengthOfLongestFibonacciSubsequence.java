package com.leiqjl;

/**
 * 873. Length of Longest Fibonacci Subsequence - Medium
 */
public class LengthOfLongestFibonacciSubsequence {

    //Constraints:
    //
    //3 <= arr.length <= 1000
    //1 <= arr[i] < arr[i + 1] <= 10^9
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int maxLen = Integer.MIN_VALUE;
        for (int i = 2; i < n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum < arr[i]) {
                    l++;
                } else if (sum > arr[i]) {
                    r--;
                } else {
                    dp[r][i] = dp[l][r] + 1;
                    maxLen = Math.max(maxLen, dp[r][i]);
                    l++;
                    r--;
                }
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen + 2;
    }

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence l = new LengthOfLongestFibonacciSubsequence();
        assert l.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}) == 5;
        assert l.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}) == 3;
    }
}
