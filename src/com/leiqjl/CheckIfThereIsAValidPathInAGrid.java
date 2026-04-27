package com.leiqjl;

/**
 * 1391. Check if There is a Valid Path in a Grid - Medium
 * You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:
 * <p>
 * - 1 which means a street connecting the left cell and the right cell.
 * - 2 which means a street connecting the upper cell and the lower cell.
 * - 3 which means a street connecting the left cell and the lower cell.
 * - 4 which means a street connecting the right cell and the lower cell.
 * - 5 which means a street connecting the left cell and the upper cell.
 * - 6 which means a street connecting the right cell and the upper cell.
 */
public class CheckIfThereIsAValidPathInAGrid {
    // 0 N
    // 1 E
    // 2 S
    // 3 W
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] connections = {
            {-1, 1, -1, 3},
            {0, -1, 2, -1},
            {3, 2, -1, -1},
            {1, -1, -1, 2},
            {-1, 0, 3, -1},
            {-1, -1, 1, 0}
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) {
            return true;
        }
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int cur = grid[0][0] - 1;
        for (int dir : connections[cur]) {
            if (dir == -1) {
                continue;
            }
            if (dfs(grid, dirs[dir][0], dirs[dir][1], m, n, visited, dir)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited, int prevDir) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        int cur = grid[i][j] - 1;
        if (connections[cur][prevDir] == -1) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        int dir = connections[cur][prevDir];
        boolean res = dfs(grid, i + dirs[dir][0], j + dirs[dir][1], m, n, visited, dir);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        CheckIfThereIsAValidPathInAGrid c = new CheckIfThereIsAValidPathInAGrid();
        //Input: grid = [[2,4,3],[6,5,2]]
        //Output: true
        assert c.hasValidPath(new int[][]{{2, 4, 3}, {6, 5, 2}});
        //Input: grid = [[1,2,1],[1,2,1]]
        //Output: false
        assert !c.hasValidPath(new int[][]{{1, 2, 1}, {1, 2, 1}});
        //Input: grid = [[1,1,2]]
        //Output: false
        assert !c.hasValidPath(new int[][]{{1, 1, 2}});
        //Input: grid = [[4,1],[6,1]]
        //Output: true
        assert c.hasValidPath(new int[][]{{4, 1}, {6, 1}});
        //Input: grid = [[1]]
        //Output: true
        assert c.hasValidPath(new int[][]{{1}});
    }


}
