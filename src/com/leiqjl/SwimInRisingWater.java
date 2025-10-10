package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 778. Swim in Rising Water - Hard
 */
public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{0, 0, grid[0][0]});
        int res = grid[0][0];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res = Math.max(res, cur[2]);
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                return res;
            }
            for (int[] dir : dirs) {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                pq.offer(new int[]{r, c, grid[r][c]});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SwimInRisingWater s = new SwimInRisingWater();
        assert s.swimInWater(new int[][]{{0, 2}, {1, 3}}) == 3;
        assert s.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}) == 16;
    }
}
