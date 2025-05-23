package com.leiqjl;

/**
 * 3068. Find the Maximum Sum of Node Values - Hard
 */
public class FindTheMaximumSumOfNodeValues {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int minPositive = Integer.MAX_VALUE;
        int maxNegative = Integer.MIN_VALUE;
        int count = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            int diff = (num ^ k) - num;
            if (diff > 0) {
                minPositive = Math.min(minPositive, diff);
                sum += diff;
                count++;
            } else {
                maxNegative = Math.max(maxNegative, diff);
            }
        }
        return (count & 1) == 1 ? Math.max(sum - minPositive, sum + maxNegative) : sum;
    }

    public long maximumValueSum1(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        dp[n][1] = 0;
        dp[n][0] = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int isEven = 0; isEven <= 1; isEven++) {
                //performed
                long performed = dp[i + 1][1 - isEven] == -1 ? -1 : dp[i + 1][1 - isEven] + (nums[i] ^ k);
                //unperformed
                long unperformed = dp[i + 1][isEven] == -1 ? -1 : dp[i + 1][isEven] + nums[i];
                dp[i][isEven] = Math.max(performed, unperformed);
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        FindTheMaximumSumOfNodeValues f = new FindTheMaximumSumOfNodeValues();
        //Input: nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
        //Output: 6
        assert f.maximumValueSum(new int[]{1, 2, 1}, 3, new int[][]{{0, 1}, {0, 2}}) == 6;
        //Input: nums = [2,3], k = 7, edges = [[0,1]]
        //Output: 9
        assert f.maximumValueSum(new int[]{2, 3}, 7, new int[][]{{0, 1}}) == 9;
        //Input: nums = [7,7,7,7,7,7], k = 3, edges = [[0,1],[0,2],[0,3],[0,4],[0,5]]
        //Output: 42
        assert f.maximumValueSum(new int[]{7, 7, 7, 7, 7, 7}, 3, new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}}) == 42;
    }
}
