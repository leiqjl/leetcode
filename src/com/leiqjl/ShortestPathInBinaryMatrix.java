package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1091. Shortest Path in Binary Matrix - Medium
 */
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        int path = 0;
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            path++;
            while (size > 0) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == m - 1 && y == n - 1) {
                    return path;
                }
                for (int r = Math.max(0, x - 1); r <= Math.min(m - 1, x + 1); r++) {
                    for (int c = Math.max(0, y - 1); c <= Math.min(n - 1, y + 1); c++) {
                        if ((r == x && c == y) || visit[r][c] || grid[r][c] == 1) {
                            continue;
                        }
                        q.offer(new int[]{r, c});
                        visit[r][c] = true;
                    }
                }
                size--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix s = new ShortestPathInBinaryMatrix();
        //Input: grid = [[0,1],[1,0]]
        //Output: 2
        int[][] grid = {{0, 1}, {1, 0}};
        assert s.shortestPathBinaryMatrix(grid) == 2;
        //Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
        //Output: 4
        int[][] grid1 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        assert s.shortestPathBinaryMatrix(grid1) == 4;
        //Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
        //Output: -1
        int[][] grid2 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        assert s.shortestPathBinaryMatrix(grid2) == -1;
    }
}
