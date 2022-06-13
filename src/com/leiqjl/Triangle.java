package com.leiqjl;

import java.util.List;

/**
 * 120. Triangle - Medium
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Triangle {
    //Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
    //O(n) space
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int col = 0; col < n; col++) {
            dp[col] = triangle.get(n - 1).get(col);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = triangle.get(n - 1).get(col);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + triangle.get(row).get(col);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        //Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        //Output: 11
        //Explanation: The triangle looks like:
        //   2
        //  3 4
        // 6 5 7
        //4 1 8 3
        //The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        assert t.minimumTotal(triangle) == 11;
    }
}
