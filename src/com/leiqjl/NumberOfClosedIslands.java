package com.leiqjl;

/**
 * 1254. Number of Closed Islands - Medium
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 */
public class NumberOfClosedIslands {
    int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 || visited[i][j]) {
                    continue;
                }
                if (dfs(i, j, m, n, grid, visited)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean dfs(int r, int c, int m, int n, int[][] grid, boolean[][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }
        if (grid[r][c] == 1 || visited[r][c]) {
            return true;
        }
        visited[r][c] = true;
        boolean closed = true;
        for (int i = 0; i < 4; i++) {
            int x = r + d[i][0];
            int y = c + d[i][1];
            if (!dfs(x, y, m, n, grid, visited)) {
                closed = false;
            }
        }
        return closed;
    }

    public static void main(String[] args) {
        NumberOfClosedIslands n = new NumberOfClosedIslands();

        int[][] grid1 = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        assert n.closedIsland(grid1) == 2;

        int[][] grid2 = {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        assert n.closedIsland(grid2) == 1;

        int[][] grid3 = {{1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}};
        assert n.closedIsland(grid3) == 2;

    }
}
