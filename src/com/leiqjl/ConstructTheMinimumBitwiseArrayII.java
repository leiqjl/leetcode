package com.leiqjl;

import java.util.Arrays;
import java.util.List;

/**
 * 3315. Construct the Minimum Bitwise Array II - Easy
 * You are given an array nums consisting of n prime integers.
 * <p>
 * You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].
 * <p>
 * Additionally, you must minimize each value of ans[i] in the resulting array.
 * <p>
 * If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.
 */
public class ConstructTheMinimumBitwiseArrayII {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == 2) {
                res[i] = -1;
            } else {
                res[i] = calculate(nums.get(i));
            }
        }
        return res;
    }

    private int calculate(int num) {
        int index = 0;
        while ((num & (1 << index)) != 0) {
            index++;
        }
        index = index - 1;
        return num ^ (1 << index);
    }

    public static void main(String[] args) {
        ConstructTheMinimumBitwiseArrayII c = new ConstructTheMinimumBitwiseArrayII();
        //Input: nums = [2,3,5,7]
        //Output: [-1,1,4,3]
        System.out.println(Arrays.toString(c.minBitwiseArray(List.of(2, 3, 5, 7))));
    }
}
