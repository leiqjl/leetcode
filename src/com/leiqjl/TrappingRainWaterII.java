package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 407. Trapping Rain Water II - Hard
 * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map,
 * return the volume of water it can trap after raining.
 */
public class TrappingRainWaterII {

    //Constraints:
    //
    //m == heightMap.length
    //n == heightMap[i].length
    //1 <= m, n <= 200
    //0 <= heightMap[i][j] <= 2 * 10^4

    //minHeap + bfs
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] seen = new boolean[m][n];
        //row col height
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // xxxxxx
        // x    x
        // xxxxxx
        //把四个边界加入minHeap
        for (int i = 0; i < m; i++) {
            minHeap.add(new int[]{i, 0, heightMap[i][0]});
            seen[i][0] = true;
            minHeap.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            seen[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            minHeap.add(new int[]{0, j, heightMap[0][j]});
            seen[0][j] = true;
            minHeap.add(new int[]{m - 1, j, heightMap[m - 1][j]});
            seen[m - 1][j] = true;
        }
        int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int res = 0;
        //bfs 遍历minHeap
        while (!minHeap.isEmpty()) {
            int[] min = minHeap.remove();
            int minHeight = min[2];
            for (int[] dir : d) {
                int x = min[0] + dir[0];
                int y = min[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y]) {
                    int height = heightMap[x][y];
                    if (minHeight > height) {
                        height = minHeight;
                        res += minHeight - heightMap[x][y];
                    }
                    minHeap.add(new int[]{x, y, height});
                    seen[x][y] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWaterII t = new TrappingRainWaterII();
        assert t.trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}) == 4;
        assert t.trapRainWater(new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}) == 10;
        assert t.trapRainWater(new int[][]{{5, 8, 7, 7}, {5, 2, 1, 5}, {7, 1, 7, 1}, {8, 9, 6, 9}, {9, 8, 9, 9}}) == 12;
    }
}
