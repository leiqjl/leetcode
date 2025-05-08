package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3342. Find Minimum Time to Reach Last Room II - Medium
 * There is a dungeon with n x m rooms arranged as a grid.
 * <p>
 * You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room.
 * You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.
 * <p>
 * Return the minimum time to reach the room (n - 1, m - 1).
 * <p>
 * Two rooms are adjacent if they share a common wall, either horizontally or vertically.
 */
public class FindMinimumTimeToReachLastRoomII {

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
        minHeap.offer(new int[]{0, 1, 0, 0});
        int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            int curX = poll[2];
            int curY = poll[3];
            int step = poll[1];
            visited[curX][curY] = true;
            for (int[] dir : d) {
                int x = curX + dir[0];
                int y = curY + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    int curDist = Math.max(dist[curX][curY], moveTime[x][y]) + step;
                    if (curDist < dist[x][y]) {
                        dist[x][y] = curDist;
                        minHeap.offer(new int[]{curDist, 3 - step, x, y});
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }

    public static void main(String[] args) {
        FindMinimumTimeToReachLastRoomII f = new FindMinimumTimeToReachLastRoomII();
        //Input: moveTime = [[0,4],[4,4]]
        //
        //Output: 7
        //
        //Explanation:
        //
        //The minimum time required is 7 seconds.
        //
        //At time t == 4, move from room (0, 0) to room (1, 0) in one second.
        //At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.
        assert f.minTimeToReach(new int[][]{{0, 4}, {4, 4}}) == 7;
        //Input: moveTime = [[0,0,0,0],[0,0,0,0]]
        //
        //Output: 6
        //
        //Explanation:
        //
        //The minimum time required is 6 seconds.
        //
        //At time t == 0, move from room (0, 0) to room (1, 0) in one second.
        //At time t == 1, move from room (1, 0) to room (1, 1) in two seconds.
        //At time t == 3, move from room (1, 1) to room (1, 2) in one second.
        //At time t == 4, move from room (1, 2) to room (1, 3) in two seconds.
        assert f.minTimeToReach(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}}) == 6;
        //Input: moveTime = [[0,1],[1,2]]
        //
        //Output: 4
        assert f.minTimeToReach(new int[][]{{0, 1}, {1, 2}}) == 4;
    }
}
