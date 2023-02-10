package com.leiqjl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. As Far from Land as Possible - Medium
 */
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visit[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int dis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] temp = queue.remove();
                for (int[] dir : d) {
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && !visit[x][y]) {
                        queue.add(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
                size--;
            }
            dis++;
        }
        return dis == 1 ? -1 : dis - 1;
    }

    public static void main(String[] args) {
        AsFarFromLandAsPossible a = new AsFarFromLandAsPossible();
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        assert a.maxDistance(grid) == 2;
        int[][] grid1 = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assert a.maxDistance(grid1) == 4;
    }
}
