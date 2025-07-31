package com.leiqjl;

import java.util.HashSet;

/**
 * 898. Bitwise ORs of Subarrays - Medium
 */
public class BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> curSet = new HashSet<>();
        curSet.add(0);
        for (int num : arr) {
            HashSet<Integer> nextSet = new HashSet<>();
            for (int c : curSet) {
                nextSet.add(c | num);
            }
            nextSet.add(num);
            curSet = nextSet;
            hashSet.addAll(curSet);
        }
        return hashSet.size();
    }
}
