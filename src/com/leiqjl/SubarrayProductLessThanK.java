package com.leiqjl;

/**
 * 713. Subarray Product Less Than K - Medium
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 */
public class SubarrayProductLessThanK {
    //Constraints:
    //
    //1 <= nums.length <= 3 * 10^4
    //1 <= nums[i] <= 1000
    //0 <= k <= 10^6
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int winStart = 0, winEnd = 0;
        int num = 0, cur = 1;
        while (winEnd < nums.length) {
            cur *= nums[winEnd];
            while (cur >= k && winStart <= winEnd) {
                cur /= nums[winStart];
                winStart++;
            }
            num += winEnd - winStart + 1;
            winEnd++;
        }
        return num;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
        assert s.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100) == 8;
        assert s.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0) == 0;
    }
}
