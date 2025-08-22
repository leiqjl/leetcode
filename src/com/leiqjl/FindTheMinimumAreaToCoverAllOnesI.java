package com.leiqjl;

/**
 * 3195. Find the Minimum Area to Cover All Ones I - Medium
 */
public class FindTheMinimumAreaToCoverAllOnesI {
    public int minimumArea(int[][] grid) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE, u = Integer.MIN_VALUE, d = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    l = Math.min(j, l);
                    r = Math.max(j, r);
                    u = Math.max(i, u);
                    d = Math.min(i, d);
                }
            }
        }
        return l <= r ? (r - l + 1) * (u - d + 1) : 0;
    }
}
