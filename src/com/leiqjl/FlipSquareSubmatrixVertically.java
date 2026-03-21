package com.leiqjl;

/**
 * 3643. Flip Square Submatrix Vertically - Easy
 */
public class FlipSquareSubmatrixVertically {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int c = y; c < y + k; c++) {
            for (int r1 = x, r2 = x + k - 1; r1 < r2; r1++, r2--) {
                int temp = grid[r1][c];
                grid[r1][c] = grid[r2][c];
                grid[r2][c] = temp;
            }
        }
        return grid;
    }
}
