package com.leiqjl;

/**
 * 377. Combination Sum IV - Medium
 * <p>
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * <p>
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV c = new CombinationSumIV();
        //Input: nums = [1,2,3], target = 4
        //Output: 7
        int[] nums = {1, 2, 3};
        assert c.combinationSum4(nums, 4) == 7;
        //Input: nums = [9], target = 3
        //Output: 0
        int[] nums1 = {9};
        assert c.combinationSum4(nums1, 3) == 0;
        //Input: nums = [1,2,3], target = 32
        //Output: 181997601
        assert c.combinationSum4(nums, 32) == 181997601;
    }
}
