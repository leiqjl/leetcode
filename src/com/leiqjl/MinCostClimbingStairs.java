package com.leiqjl;

/**
 * 746. Min Cost Climbing Stairs - Easy
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {
    //2 <= cost.length <= 1000
    //0 <= cost[i] <= 999

    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0];
        int b = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = cost[i] + Math.min(a, b);
            a = b;
            b = temp;
        }
        return Math.min(a, b);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);
        }
        return Math.min(dp[n - 2], dp[n - 1]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        //Input: cost = [10,15,20]
        //Output: 15
        //Explanation: You will start at index 1.
        //- Pay 15 and climb two steps to reach the top.
        //The total cost is 15.
        int[] cost = {10, 15, 20};
        assert m.minCostClimbingStairs(cost) == 15;
        //Input: cost = [1,100,1,1,1,100,1,1,100,1]
        //Output: 6
        //Explanation: You will start at index 0.
        //- Pay 1 and climb two steps to reach index 2.
        //- Pay 1 and climb two steps to reach index 4.
        //- Pay 1 and climb two steps to reach index 6.
        //- Pay 1 and climb one step to reach index 7.
        //- Pay 1 and climb two steps to reach index 9.
        //- Pay 1 and climb one step to reach the top.
        //The total cost is 6.
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        assert m.minCostClimbingStairs(cost1) == 6;
    }
}
