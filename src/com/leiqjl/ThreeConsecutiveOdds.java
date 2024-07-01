package com.leiqjl;

/**
 * 1550. Three Consecutive Odds - Easy
 */
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int a : arr) {
            if ((a & 1) == 1) {
                count++;
            } else {
                count = 0;
            }

            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
