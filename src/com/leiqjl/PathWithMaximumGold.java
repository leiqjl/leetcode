package com.leiqjl;

/**
 * 1219. Path with Maximum Gold - Medium
 */
public class PathWithMaximumGold {
    int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(grid, i, j, m, n));
                if (max == total) {
                    return max;
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        int cur = grid[i][j];
        grid[i][j] = 0;
        int max = 0;
        for (int[] d : d) {
            int x = i + d[0];
            int y = j + d[1];
            max = Math.max(max, dfs(grid, x, y, m, n));
        }
        grid[i][j] = cur;
        return cur + max;
    }

    public static void main(String[] args) {
        PathWithMaximumGold p = new PathWithMaximumGold();
        //Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
        //Output: 24
        //Explanation:
        //[[0,6,0],
        // [5,8,7],
        // [0,9,0]]
        //Path to get the maximum gold, 9 -> 8 -> 7.
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        assert p.getMaximumGold(grid) == 24;
        //Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
        //Output: 28
        //Explanation:
        //[[1,0,7],
        // [2,0,6],
        // [3,4,5],
        // [0,3,0],
        // [9,0,20]]
        //Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
        int[][] grid2 = {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        assert p.getMaximumGold(grid2) == 28;
    }
}
