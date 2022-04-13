package com.leiqjl;

/**
 * 59. Spiral Matrix II - Medium
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int total = n * n, k = 1;
        int left = 0, up = 0, right = n - 1, down = n - 1;
        while (k <= total) {
            if (up <= down) {
                for (int j = left; j <= right; j++) {
                    matrix[up][j] = k++;
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = k++;
                }
                right--;
            }
            if (up <= down) {
                for (int j = right; j >= left; j--) {
                    matrix[down][j] = k++;
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = k++;
                }
                left++;
            }
        }
        return matrix;
    }
}
