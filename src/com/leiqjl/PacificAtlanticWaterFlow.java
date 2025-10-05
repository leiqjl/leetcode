package com.leiqjl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 417. Pacific Atlantic Water Flow - Medium
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * <p>
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * <p>
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * <p>
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {
    //Constraints:
    //
    //m == heights.length
    //n == heights[r].length
    //1 <= m, n <= 200
    //0 <= heights[r][c] <= 10^5

    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
            aQueue.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pQueue.offer(new int[]{0, j});
            pacific[0][j] = true;
            aQueue.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pacific, pQueue, m, n);
        bfs(heights, atlantic, aQueue, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, boolean[][] ocean, Queue<int[]> queue, int m, int n) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : DIRS) {
                int r = current[0] + dir[0];
                int c = current[1] + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || ocean[r][c] || heights[r][c] < heights[current[0]][current[1]]) {
                    continue;
                }
                ocean[r][c] = true;
                queue.offer(new int[]{r, c});
            }
        }
    }
}
