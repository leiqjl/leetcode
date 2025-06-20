package com.leiqjl;

/**
 * 3443. Maximum Manhattan Distance After K Changes - Medium
 */
public class MaximumManhattanDistanceAfterKChanges {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int yDis = 0, xDis = 0;
        int maxDis = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'N':
                    yDis++;
                    break;
                case 'S':
                    yDis--;
                    break;
                case 'E':
                    xDis++;
                    break;
                case 'W':
                    xDis--;
                    break;
            }
            maxDis = Math.max(maxDis, Math.min(Math.abs(xDis) + Math.abs(yDis) + k * 2, i + 1));
        }
        return maxDis;
    }
}
