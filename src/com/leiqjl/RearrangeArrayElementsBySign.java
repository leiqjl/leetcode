package com.leiqjl;

/**
 * 2149. Rearrange Array Elements by Sign - Medium
 */
public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int posIdx = 0, negIdx = 1;
        for (int num : nums) {
            if (num > 0) {
                res[posIdx] = num;
                posIdx += 2;
            } else {
                res[negIdx] = num;
                negIdx += 2;
            }
        }
        return res;
    }
}
