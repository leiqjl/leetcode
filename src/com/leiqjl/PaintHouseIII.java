package com.leiqjl;

import java.util.Arrays;

/**
 * 1473. Paint House III - Hard
 * There is a row of m houses in a small city, each house must be painted with one of the n colors (labeled from 1 to n),
 * some houses that have been painted last summer should not be painted again.
 * <p>
 * A neighborhood is a maximal group of continuous houses that are painted with the same color.
 * <p>
 * - For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2}, {3,3}, {2}, {1,1}].
 * <p>
 * Given an array houses, an m x n matrix cost and an integer target where:
 * <p>
 * - houses[i]: is the color of the house i, and 0 if the house is not painted yet.
 * - cost[i][j]: is the cost of paint the house i with the color j + 1.
 * <p>
 * Return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods.
 * If it is not possible, return -1.
 */
public class PaintHouseIII {
    //m == houses.length == cost.length
    //n == cost[i].length
    //1 <= m <= 100
    //1 <= n <= 20
    //1 <= target <= m
    //0 <= houses[i] <= n
    //1 <= cost[i][j] <= 10^4

    // m - houses
    // n - colors
    //time(mtn^2) space O(mtn)
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // 100 * 10^4 +1
        int maxCost = 1000001;
        int[][][] dp = new int[m][target + 1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= target; j++) {
                Arrays.fill(dp[i][j], maxCost);
            }
        }
        for (int c = 1; c <= n; c++) {
            if (houses[0] == 0) {
                dp[0][1][c - 1] = cost[0][c - 1];
            } else if (houses[0] == c) {
                dp[0][1][c - 1] = 0;
            }
        }
        for (int house = 1; house < m; house++) {
            for (int neighbor = 1; neighbor <= Math.min(house + 1, target); neighbor++) {
                for (int color = 1; color <= n; color++) {
                    //house is painted
                    if (houses[house] != 0 && houses[house] != color) {
                        continue;
                    }
                    int curCost = Integer.MAX_VALUE;
                    for (int preColor = 1; preColor <= n; preColor++) {
                        if (preColor == color) {
                            curCost = Math.min(curCost, dp[house - 1][neighbor][preColor - 1]);
                        } else {
                            curCost = Math.min(curCost, dp[house - 1][neighbor - 1][preColor - 1]);
                        }
                    }
                    int paintCost = houses[house] == 0 ? cost[house][color - 1] : 0;
                    dp[house][neighbor][color - 1] = curCost + paintCost;
                }
            }
        }
        int min = maxCost;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[m - 1][target][i]);
        }
        return min == maxCost ? -1 : min;
    }

    public static void main(String[] args) {
        PaintHouseIII p = new PaintHouseIII();
        //Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
        //Output: 9
        //Explanation: Paint houses of this way [1,2,2,1,1]
        //This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
        //Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.
        int[] houses = {0, 0, 0, 0, 0};
        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        assert p.minCost(houses, cost, 5, 2, 3) == 9;
        //Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
        //Output: 11
        //Explanation: Some houses are already painted, Paint the houses of this way [2,2,1,2,2]
        //This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}].
        //Cost of paint the first and last house (10 + 1) = 11.
        int[] houses1 = {0, 2, 1, 2, 0};
        int[][] cost1 = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        assert p.minCost(houses1, cost1, 5, 2, 3) == 11;
        //Input: houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
        //Output: -1
        //Explanation: Houses are already painted with a total of 4 neighborhoods [{3},{1},{2},{3}] different of target = 3.
        int[] houses2 = {3, 1, 2, 3};
        int[][] cost2 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assert p.minCost(houses2, cost2, 4, 3, 3) == -1;
    }
}
