package com.leiqjl;

import java.util.Arrays;

/**
 * 1798. Maximum Number of Consecutive Values You Can Make - Medium
 */
public class MaximumNumberOfConsecutiveValuesYouCanMake {
    public int getMaximumConsecutive(int[] coins) {
        int max = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin <= max) {
                max += coin;
            } else {
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumNumberOfConsecutiveValuesYouCanMake m = new MaximumNumberOfConsecutiveValuesYouCanMake();
        assert m.getMaximumConsecutive(new int[]{1, 3}) == 2;
        assert m.getMaximumConsecutive(new int[]{1, 1, 1, 4}) == 8;
        assert m.getMaximumConsecutive(new int[]{1, 4, 10, 3, 1}) == 20;
    }
}
