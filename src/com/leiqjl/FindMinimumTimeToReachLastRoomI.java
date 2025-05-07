package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3341. Find Minimum Time to Reach Last Room I - Medium
 * There is a dungeon with n x m rooms arranged as a grid.
 * <p>
 * You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room.
 * You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes exactly one second.
 * <p>
 * Return the minimum time to reach the room (n - 1, m - 1).
 * <p>
 * Two rooms are adjacent if they share a common wall, either horizontally or vertically.
 */
public class FindMinimumTimeToReachLastRoomI {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[0][0] = 0;
        minHeap.offer(new int[]{0, 0, 0});
        int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            int curX = poll[1];
            int curY = poll[2];
            visited[curX][curY] = true;
            for (int[] dir : d) {
                int x = curX + dir[0];
                int y = curY + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    int curDist = Math.max(dist[curX][curY], moveTime[x][y]) + 1;
                    if (curDist < dist[x][y]) {
                        dist[x][y] = curDist;
                        minHeap.offer(new int[]{curDist, x, y});
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }

    public static void main(String[] args) {
        FindMinimumTimeToReachLastRoomI f = new FindMinimumTimeToReachLastRoomI();
        //Input: moveTime = [[0,4],[4,4]]
        //Output: 6
        //
        //Explanation:
        //The minimum time required is 6 seconds.
        //At time t == 4, move from room (0, 0) to room (1, 0) in one second.
        //At time t == 5, move from room (1, 0) to room (1, 1) in one second.
        assert f.minTimeToReach(new int[][]{{0, 4}, {4, 4}}) == 6;
        //Input: moveTime = [[0,0,0],[0,0,0]]
        //Output: 3
        //
        //Explanation:
        //The minimum time required is 3 seconds.
        //At time t == 0, move from room (0, 0) to room (1, 0) in one second.
        //At time t == 1, move from room (1, 0) to room (1, 1) in one second.
        //At time t == 2, move from room (1, 1) to room (1, 2) in one second.
        assert f.minTimeToReach(new int[][]{{0, 0, 0}, {0, 0, 0}}) == 3;
        //Input: moveTime = [[0,1],[1,2]]
        //
        //Output: 3
        assert f.minTimeToReach(new int[][]{{0, 1}, {1, 2}}) == 3;
    }
}
