package com.leiqjl;

import java.util.Arrays;

/**
 * 2154. Keep Multiplying Found Values by Two - Easy
 */
public class KeepMultiplyingFoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (original == num) {
                original *= 2;
            }
        }
        return original;
    }
}
