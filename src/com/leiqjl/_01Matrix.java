package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 542. 01 Matrix - Medium
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two cells sharing a common edge is 1.
 */
public class _01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dis = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = -1;
                }
            }
        }
        int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : d) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && dis[x][y] == -1) {
                        queue.offer(new int[]{x, y});
                        dis[x][y] = dis[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
        return dis;
    }
}
