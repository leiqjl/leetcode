package com.leiqjl;

/**
 * 416. Partition Equal Subset Sum - Medium
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 */
public class PartitionEqualSubsetSum {

    //1 <= nums.length <= 200
    //1 <= nums[i] <= 100
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        assert p.canPartition(new int[]{1, 5, 11, 5});
        assert !p.canPartition(new int[]{1, 2, 3, 5});
    }
}
