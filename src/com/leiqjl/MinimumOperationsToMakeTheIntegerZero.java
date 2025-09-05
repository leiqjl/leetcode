package com.leiqjl;

/**
 * 2749. Minimum Operations to Make the Integer Zero - Medium
 */
public class MinimumOperationsToMakeTheIntegerZero {
    //Constraints:
    //
    //1 <= num1 <= 10^9
    //-10^9 <= num2 <= 10^9

    // nums1 - (2^i+nums2)
    public int makeTheIntegerZero(int num1, int num2) {
        int n = 1;
        while (true) {
            long x = num1 - (long) num2 * n;
            if (x < n) {
                return -1;
            }
            if (n >= Long.bitCount(x)) {
                return n;
            }
            n++;
        }
    }
}
