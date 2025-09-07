package com.leiqjl;

/**
 * 1304. Find N Unique Integers Sum up to Zero - Easy
 */
public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            res[i] = i + 1;
            sum += res[i];
        }
        res[n - 1] = -sum;
        return res;
    }
}
