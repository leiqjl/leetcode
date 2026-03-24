package com.leiqjl;

/**
 * 2906. Construct Product Matrix - Medium
 */
public class ConstructProductMatrix {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        long suffix = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                res[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % mod;
            }
        }
        long prefix = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = (int) (((long) res[i][j] * prefix) % mod);
                prefix = (prefix * grid[i][j]) % mod;
            }
        }
        return res;
    }
}
