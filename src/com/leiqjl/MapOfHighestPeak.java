package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1765. Map of Highest Peak - Medium
 */
public class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;
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
                    if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
                        queue.offer(new int[]{x, y});
                        ans[x][y] = ans[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
        return ans;
    }
}
