package com.leiqjl;

/**
 * 2106. Maximum Fruits Harvested After at Most K Steps - Hard
 */
public class MaximumFruitsHarvestedAfterAtMostKSteps {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0, right = 0;
        int n = fruits.length;
        int max = 0;
        int cur = 0;
        while (right < n) {
            cur += fruits[right][1];
            while (left <= right && calculateSteps(fruits, left, right, startPos) > k) {
                cur -= fruits[left][1];
                left++;
            }
            max = Math.max(max, cur);
            right++;
        }
        return max;
    }

    private int calculateSteps(int[][] fruits, int left, int right, int startPos) {
        int steps = fruits[right][0] - fruits[left][0];
        return steps + Math.min(Math.abs(startPos - fruits[right][0]), Math.abs(startPos - fruits[left][0]));
    }
}
