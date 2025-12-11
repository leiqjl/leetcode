package com.leiqjl;

import java.util.Arrays;

/**
 * 3531. Count Covered Buildings - Medium
 */
public class CountCoveredBuildings {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];
        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);
        for (int[] building : buildings) {
            int c = building[0];
            int r = building[1];
            maxRow[r] = Math.max(maxRow[r], c);
            minRow[r] = Math.min(minRow[r], c);
            maxCol[c] = Math.max(maxCol[c], r);
            minCol[c] = Math.min(minCol[c], r);
        }
        int count = 0;
        for (int[] building : buildings) {
            int c = building[0];
            int r = building[1];
            if (c > minRow[r] && c < maxRow[r] && r > minCol[c] && r < maxCol[c]) {
                count++;
            }
        }
        return count;
    }
}
