package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 695. Max Area of Island - Medium
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= 0) {
                    continue;
                }
                int sum = 0;
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int curX = poll[0];
                    int curY = poll[1];
                    if (grid[curX][curY] <= 0) {
                        continue;
                    }
                    sum++;
                    for (int k = 0; k < 4; k++) {
                        int x = poll[0] + d[k][0];
                        int y = poll[1] + d[k][1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            queue.offer(new int[]{x, y});
                        }
                    }
                    grid[curX][curY] = -1;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        //Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
        //Output: 6
        //Explanation: The answer is not 11, because the island must be connected 4-directionally.
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        assert m.maxAreaOfIsland(grid) == 6;
        //Input: grid = [[0,0,0,0,0,0,0,0]]
        //Output: 0
        int[][] grid1 = {{0, 0, 0, 0, 0, 0, 0, 0}};
        assert m.maxAreaOfIsland(grid1) == 0;

        int[][] grid2 = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        assert m.maxAreaOfIsland(grid2) == 4;
    }

}
