package com.leiqjl;

/**
 * 2873. Maximum Value of an Ordered Triplet I - Easy
 * You are given a 0-indexed integer array nums.
 * <p>
 * Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
 * <p>
 * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
 */
public class MaximumValueOfAnOrderedTripletI {
    //Constraints:
    //
    //3 <= nums.length <= 100
    //1 <= nums[i] <= 10^6
    public long maximumTripletValue(int[] nums) {
        int max = 0;
        int maxDiff = 0;
        long maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, (long) maxDiff * num);
            max = Math.max(max, num);
            maxDiff = Math.max(maxDiff, max - num);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        MaximumValueOfAnOrderedTripletI m = new MaximumValueOfAnOrderedTripletI();
        assert m.maximumTripletValue(new int[]{12, 6, 1, 2, 7}) == 77;
        assert m.maximumTripletValue(new int[]{1, 10, 3, 4, 19}) == 133;
        assert m.maximumTripletValue(new int[]{1, 2, 3}) == 0;
        assert m.maximumTripletValue(new int[]{10, 8, 12, 14}) == 28;
    }
}
