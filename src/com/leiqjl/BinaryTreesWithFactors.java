package com.leiqjl;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 823. Binary Trees With Factors - Medium
 */
public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        HashMap<Integer, Long> dp = new HashMap<>();
        Arrays.sort(arr);
        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i] / arr[j], 0L)) % mod);
                }
            }
            result = (result + dp.get(arr[i])) % mod;
        }
        return (int) result;
    }
}
