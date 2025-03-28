package com.leiqjl;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2503. Maximum Number of Points From Grid Queries - Hard
 */
public class MaximumNumberOfPointsFromGridQueries {
    //Constraints:
    //
    //m == grid.length
    //n == grid[i].length
    //2 <= m, n <= 1000
    //4 <= m * n <= 10^5
    //k == queries.length
    //1 <= k <= 10^4
    //1 <= grid[i][j], queries[i] <= 10^6

    //O(k log k + m×n log (m×n))
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;
        int[] res = new int[k];
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queriesMinHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            queriesMinHeap.offer(new int[]{queries[i], i});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int points = 0;
        int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while (!queriesMinHeap.isEmpty()) {
            int queryIndex = queriesMinHeap.peek()[1];
            int queryVal = queriesMinHeap.peek()[0];
            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryVal) {
                int[] cur = minHeap.poll();
                points++;
                for (int[] dir : d) {
                    int x = cur[1] + dir[0];
                    int y = cur[2] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        minHeap.add(new int[]{grid[x][y], x, y});
                        visited[x][y] = true;
                    }
                }
            }
            queriesMinHeap.poll();
            res[queryIndex] = points;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfPointsFromGridQueries m = new MaximumNumberOfPointsFromGridQueries();
        //Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
        //Output: [5,8,1]
        assert Arrays.toString(m.maxPoints(new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, new int[]{5, 6, 2})).equals("[5, 8, 1]");
        //Input: grid = [[5,2,1],[1,1,2]], queries = [3]
        //Output: [0]
        assert Arrays.toString(m.maxPoints(new int[][]{{5, 2, 1}, {1, 1, 2}}, new int[]{3})).equals("[0]");
    }
}
