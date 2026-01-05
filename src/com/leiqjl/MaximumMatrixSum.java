package com.leiqjl;

/**
 * 1975. Maximum Matrix Sum - Medium
 * You are given an n x n integer matrix. You can do the following operation any number of times:
 * <p>
 * ·Choose any two adjacent elements of matrix and multiply each of them by -1.
 * Two elements are considered adjacent if and only if they share a border.
 * <p>
 * Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
 */
public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        boolean isOdd = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) {
                    isOdd = !isOdd;
                }
            }
        }
        if (isOdd) {
            sum -= min * 2L;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumMatrixSum m = new MaximumMatrixSum();
        assert m.maxMatrixSum(new int[][]{{1, -1}, {-1, 1}}) == 4;
        assert m.maxMatrixSum(new int[][]{{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}}) == 16;
    }
}
