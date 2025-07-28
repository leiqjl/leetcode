package com.leiqjl;

/**
 * 2044. Count Number of Maximum Bitwise-OR Subsets - Medium
 */
public class CountNumberOfMaximumBitwiseORSubsets {
    //Constraints:
    //
    //1 <= nums.length <= 16
    //1 <= nums[i] <= 10^5
    public int countMaxOrSubsets(int[] nums) {
        int[] dp = new int[1 << 17];
        dp[0] = 1;
        int maxBit = 0;
        for (int num : nums) {
            for (int i = maxBit; i >= 0; i--) {
                dp[i | num] += dp[i];
            }
            maxBit |= num;
        }
        return dp[maxBit];
    }
}
