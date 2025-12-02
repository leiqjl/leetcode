package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 3623. Count Number of Trapezoids I - Medium
 */
public class CountNumberOfTrapezoidsI {
    public int countTrapezoids(int[][] points) {
        long mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }
        long res = 0;
        long sum = 0;
        for (int count : map.values()) {
            if (count >= 2) {
                long cur = ((long) count * (count - 1) / 2);
                res = (res + sum * cur) % mod;
                sum = (sum + cur) % mod;
            }
        }
        return (int) res;
    }
}
