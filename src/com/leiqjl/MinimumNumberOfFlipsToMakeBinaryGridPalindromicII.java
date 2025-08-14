package com.leiqjl;

/**
 * 3240. Minimum Number of Flips to Make Binary Grid Palindromic II - Medium
 */
public class MinimumNumberOfFlipsToMakeBinaryGridPalindromicII {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        // 1,1 and 1,0
        int oneone = 0;
        int onezero = 0;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int c = grid[i][j] + grid[i][n - 1 - j] + grid[m - 1 - i][j] + grid[m - 1 - i][n - 1 - j];
                count += Math.min(c, 4 - c);
            }
            if (n % 2 == 1) {
                int c = grid[i][n / 2] + grid[m - 1 - i][n / 2];
                if (c == 1) {
                    onezero++;
                }
                if (c == 2) {
                    oneone++;
                }
            }
        }
        if (m % 2 == 1) {
            for (int j = 0; j < n / 2; j++) {
                int c = grid[m / 2][j] + grid[m / 2][n - 1 - j];
                if (c == 1) {
                    onezero++;
                }
                if (c == 2) {
                    oneone++;
                }
            }
            if (n % 2 == 1) {
                count += grid[m / 2][n / 2];
            }
        }

        if ((oneone & 1) == 0 || onezero > 0) {
            return count + onezero;
        } else {
            return count + 2;
        }
    }
}
