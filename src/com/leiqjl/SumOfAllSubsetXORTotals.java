package com.leiqjl;

/**
 * 1863. Sum of All Subset XOR Totals - Easy
 */
public class SumOfAllSubsetXORTotals {
    //{p, q} p+q+p^q
    //xth bit 2^(n-1) chosen
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int num : nums) {
            or |= num;
        }
        return or << (nums.length - 1);
    }
}
