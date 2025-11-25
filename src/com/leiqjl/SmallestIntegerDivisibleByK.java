package com.leiqjl;

/**
 * 1015. Smallest Integer Divisible by K - Medium
 */
public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        int reminder = 0;
        for (int i = 1; i <= k; i++) {
            reminder = (reminder * 10 + 1) % k;
            if (reminder == 0) {
                return i;
            }
        }
        return -1;
    }
}
