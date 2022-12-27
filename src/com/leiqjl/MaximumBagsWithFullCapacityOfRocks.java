package com.leiqjl;

import java.util.Arrays;

/**
 * 2279. Maximum Bags With Full Capacity of Rocks - Medium
 */
public class MaximumBagsWithFullCapacityOfRocks {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] remain = new int[n];
        for (int i = 0; i < n; i++) {
            remain[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remain);
        int i = 0;
        while (i < n) {
            if (remain[i] > additionalRocks) {
                break;
            }
            additionalRocks -= remain[i];
            i++;
        }
        return i;
    }
}
