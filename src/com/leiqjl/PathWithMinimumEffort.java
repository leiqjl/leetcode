package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1631. Path With Minimum Effort - Medium
 */
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0});
        int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int curEffort = cur[2];
            if (curEffort > effort[x][y]) {
                continue;
            }
            if (x == m - 1 && y == n - 1) {
                return curEffort;
            }
            for (int k = 0; k < 4; k++) {
                int nx = x + d[k][0];
                int ny = y + d[k][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nextEffort = Math.max(curEffort, Math.abs(heights[nx][ny] - heights[x][y]));
                    if (nextEffort < effort[nx][ny]) {
                        effort[nx][ny] = nextEffort;
                        pq.offer(new int[]{nx, ny, nextEffort});
                    }
                }
            }
        }
        return -1;
    }
}
