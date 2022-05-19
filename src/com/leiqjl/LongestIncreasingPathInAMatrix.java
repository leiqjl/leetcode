package com.leiqjl;

/**
 * 329. Longest Increasing Path in a Matrix - Hard
 */
public class LongestIncreasingPathInAMatrix {
    int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    //dfs+memory
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] mem = new int[m][n];
        int maxLen = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, mem);
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] mem) {
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        int maxLen = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, x, y, m, n, mem);
            maxLen = Math.max(len, maxLen);
        }
        mem[i][j] = maxLen;
        return maxLen;
    }
}
