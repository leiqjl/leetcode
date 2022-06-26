package com.leiqjl;

/**
 * 1423. Maximum Points You Can Obtain from Cards - Medium
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int rSum = 0;
        for (int i = n - 1; i > n - 1 - k; i--) {
            rSum += cardPoints[i];
        }
        int lSum = 0, max = rSum;
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
            rSum -= cardPoints[n - k + i];
            max = Math.max(max, lSum + rSum);
        }
        return max;
    }
}
