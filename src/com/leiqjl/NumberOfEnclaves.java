package com.leiqjl;

/**
 * 1020. Number of Enclaves - Medium
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * <p>
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * <p>
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 */
public class NumberOfEnclaves {
    //Constraints:
    //
    //m == grid.length
    //n == grid[i].length
    //1 <= m, n <= 500
    //grid[i][j] is either 0 or 1.
    int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                dfs(i, 0, m, n, grid, visited);
            }
            if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
                dfs(i, n - 1, m, n, grid, visited);
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                dfs(0, j, m, n, grid, visited);
            }
            if (grid[m - 1][j] == 1 && !visited[m - 1][j]) {
                dfs(m - 1, j, m, n, grid, visited);
            }
        }
        int result = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int m, int n, int[][] grid, boolean[][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int x = r + d[i][0];
            int y = c + d[i][1];

            dfs(x, y, m, n, grid, visited);
        }
    }

    public static void main(String[] args) {
        NumberOfEnclaves n = new NumberOfEnclaves();

        int[][] grid1 = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        assert n.numEnclaves(grid1) == 3;

        int[][] grid2 = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        assert n.numEnclaves(grid2) == 0;

    }
}
