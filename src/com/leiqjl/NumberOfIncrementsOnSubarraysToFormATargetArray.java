package com.leiqjl;

/**
 * 1526. Minimum Number of Increments on Subarrays to Form a Target Array - Hard
 * You are given an integer array target. You have an integer array initial of the same size as target with all elements initially zeros.
 * <p>
 * In one operation you can choose any subarray from initial and increment each value by one.
 * <p>
 * Return the minimum number of operations to form a target array from initial.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
public class NumberOfIncrementsOnSubarraysToFormATargetArray {
    public int minNumberOperations(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                res += target[i] - target[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfIncrementsOnSubarraysToFormATargetArray n = new NumberOfIncrementsOnSubarraysToFormATargetArray();
        assert n.minNumberOperations(new int[]{1, 2, 3, 2, 1}) == 3;
        assert n.minNumberOperations(new int[]{3, 1, 1, 2}) == 4;
        assert n.minNumberOperations(new int[]{3, 1, 5, 4, 2}) == 7;
        assert n.minNumberOperations(new int[]{1, 1, 1, 1}) == 1;
    }
}
