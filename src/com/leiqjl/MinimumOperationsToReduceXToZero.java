package com.leiqjl;

/**
 * 1658. Minimum Operations to Reduce X to Zero - Medium
 */
public class MinimumOperationsToReduceXToZero {

    // [left] [total-x] [right]
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        int curSum = 0, l = 0, r = 0, res = Integer.MIN_VALUE;
        while (r < nums.length) {
            curSum += nums[r++];
            while (curSum >= target) {
                if (curSum == target) {
                    res = Math.max(res, r - l);
                }
                curSum -= nums[l++];
            }
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero m = new MinimumOperationsToReduceXToZero();
        //Input: nums = [1,1,4,2,3], x = 5
        //Output: 2
        int[] nums = {1, 1, 4, 2, 3};
        assert m.minOperations(nums, 5) == 2;
        //Input: nums = [5,6,7,8,9], x = 4
        //Output: -1
        int[] nums1 = {5, 6, 7, 8, 9};
        assert m.minOperations(nums1, 4) == -1;
        //Input: nums = [3,2,20,1,1,3], x = 10
        //Output: 5
        int[] nums2 = {3, 2, 20, 1, 1, 3};
        assert m.minOperations(nums2, 10) == 5;
    }
}
