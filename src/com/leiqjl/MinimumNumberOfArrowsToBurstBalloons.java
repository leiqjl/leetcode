package com.leiqjl;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons - Medium
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int pos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (pos < points[i][0]) {
                count++;
                pos = points[i][1];
            }
        }
        return count;
    }
}
