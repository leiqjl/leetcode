package com.leiqjl;

/**
 * 1732. Find the Highest Altitude - Easy
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int high = 0, cur = 0;
        for (int g : gain) {
            cur += g;
            high = Math.max(high, cur);
        }
        return high;
    }
}
