package com.leiqjl;

/**
 * 980. Unique Paths III - Hard
 * You are given an m x n integer array grid where grid[i][j] could be:
 * <p>
 * - 1 representing the starting square. There is exactly one starting square.
 * - 2 representing the ending square. There is exactly one ending square.
 * - 0 representing empty squares we can walk over.
 * - -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 */
public class UniquePathsIII {
    int res;

    public int uniquePathsIII(int[][] grid) {
        int empty = 1, startX = -1, startY = -1;
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(grid, startX, startY, empty);
        return res;
    }

    private void dfs(int[][] grid, int x, int y, int empty) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }
        if (grid[x][y] == 2) {
            if (empty == 0) {
                res++;
            }
            return;
        }
        grid[x][y] = -2;
        empty--;
        dfs(grid, x + 1, y, empty);
        dfs(grid, x - 1, y, empty);
        dfs(grid, x, y + 1, empty);
        dfs(grid, x, y - 1, empty);
        grid[x][y] = 0;
    }

    public static void main(String[] args) {
        UniquePathsIII u = new UniquePathsIII();
        //Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
        //Output: 2
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        assert u.uniquePathsIII(grid) == 2;
        //Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
        //Output: 4
        int[][] grid1 = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        assert u.uniquePathsIII(grid1) == 4;
        //Input: grid = [[0,1],[2,0]]
        //Output: 0
        int[][] grid2 = {{0, 1}, {2, 0}};
        assert u.uniquePathsIII(grid2) == 0;
    }
}
