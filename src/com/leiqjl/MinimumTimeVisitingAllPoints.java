package com.leiqjl;

/**
 * 1266. Minimum Time Visiting All Points - Easy
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            time += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }
        return time;
    }

    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints m = new MinimumTimeVisitingAllPoints();
        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        assert m.minTimeToVisitAllPoints(points) == 7;
        int[][] points1 = new int[][]{{3, 2}, {-2, 2}};
        assert m.minTimeToVisitAllPoints(points1) == 5;
    }
}
