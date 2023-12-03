package com.leiqjl;

import java.util.Arrays;

/**
 * 1887. Reduction Operations to Make the Array Elements Equal - Medium
 */
public class ReductionOperationsToMakeTheArrayElementsEqual {

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int result = 0, level = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                level++;
            }
            result += level;
        }
        return result;
    }

    public static void main(String[] args) {
        ReductionOperationsToMakeTheArrayElementsEqual r = new ReductionOperationsToMakeTheArrayElementsEqual();
        assert r.reductionOperations(new int[]{5, 1, 3}) == 3;
        assert r.reductionOperations(new int[]{1, 1, 1}) == 0;
        assert r.reductionOperations(new int[]{1, 1, 2, 2, 3}) == 4;
    }
}
