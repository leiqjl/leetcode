package com.leiqjl;

/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times - Medium
 * You are given an integer array nums and a positive integer k.
 * <p>
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 */
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^6
    //1 <= k <= 10^5
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int winStart = 0, winEnd = 0;
        long count = 0;
        int freq = 0;
        while (winEnd < nums.length) {
            if (nums[winEnd] == max) {
                freq++;
            }
            while (freq >= k) {
                count += (nums.length - winEnd);
                if (nums[winStart] == max) {
                    freq--;
                }
                winStart++;
            }
            winEnd++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWhereMaxElementAppearsAtLeastKTimes c = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes();
        assert c.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2) == 6;
        assert c.countSubarrays(new int[]{1, 4, 2, 1}, 3) == 0;
    }
}
