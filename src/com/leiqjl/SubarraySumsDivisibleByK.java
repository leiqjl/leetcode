package com.leiqjl;

/**
 * 974. Subarray Sums Divisible by K - Medium
 */
public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        int[] mods = new int[k];
        mods[0] = 1;
        int sumMod = 0, count = 0;
        for (int num : nums) {
            sumMod = (sumMod + num % k + k) % k;
            count += mods[sumMod];
            mods[sumMod]++;
        }
        return count;
    }
}
