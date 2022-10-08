package com.leiqjl;

/**
 * 1578. Minimum Time to Make Rope Colorful - Medium
 */
public class MinimumTimeToMakeRopeColorful {
    //n == colors.length == neededTime.length
    //1 <= n <= 10^5
    //1 <= neededTime[i] <= 10^4
    //colors contains only lowercase English letters.
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        if (n == 1) {
            return 0;
        }
        int minTime = 0;
        int maxTime = neededTime[0];
        for (int i = 1; i < n; i++) {

            if (colors.charAt(i) != colors.charAt(i - 1)) {
                maxTime = 0;
            }
            minTime += Math.min(maxTime, neededTime[i]);
            maxTime = Math.max(maxTime, neededTime[i]);
        }
        return minTime;
    }
}
