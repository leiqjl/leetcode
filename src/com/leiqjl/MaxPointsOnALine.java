package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line - Hard
 */
public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    double slope = getSlope(points[i], points[j]);
                    int count = map.getOrDefault(slope, 1) + 1;
                    map.put(slope, count);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    private double getSlope(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) {
            return Double.MAX_VALUE;
        }
        if (p1[1] == p2[1]) {
            return 0;
        }
        return (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}
