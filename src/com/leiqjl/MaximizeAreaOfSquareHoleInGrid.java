package com.leiqjl;

import java.util.Arrays;

/**
 * 2943. Maximize Area of Square Hole in Grid - Medium
 */
public class MaximizeAreaOfSquareHoleInGrid {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxH = 1;
        int maxV = 1;
        int countH = 1;
        int countV = 1;
        for (int i = 0; i < hBars.length - 1; i++) {
            if (hBars[i + 1] == hBars[i] + 1) {
                countH++;
            } else {
                countH = 1;
            }
            maxH = Math.max(maxH, countH);
        }
        for (int i = 0; i < vBars.length - 1; i++) {
            if (vBars[i + 1] == vBars[i] + 1) {
                countV++;
            } else {
                countV = 1;
            }
            maxV = Math.max(maxV, countV);
        }
        int min = Math.min(maxH + 1, maxV + 1);
        return min * min;
    }
}
