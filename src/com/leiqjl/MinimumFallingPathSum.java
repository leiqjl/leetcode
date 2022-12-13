package com.leiqjl;

/**
 * 931. Minimum Falling Path Sum - Medium
 * <p>
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int min = dp[i - 1][j];
                if (j != 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j != n - 1) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] = min + matrix[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp[n - 1][j]);
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum m = new MinimumFallingPathSum();

        //Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
        //Output: 13
        assert m.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}) == 13;

        //Input: matrix = [[-19,57],[-40,-5]]
        //Output: -59
        assert m.minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}) == -59;
    }
}
