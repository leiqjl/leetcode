package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. Two City Scheduling - Medium
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[0] - a[1]));
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length/2) {
                res += costs[i][0];
            } else {
                res += costs[i][1];
            }
        }
        return res;
    }
}
