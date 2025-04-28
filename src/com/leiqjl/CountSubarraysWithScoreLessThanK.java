package com.leiqjl;

/**
 * 2302. Count Subarrays With Score Less Than K - Hard
 * The score of an array is defined as the product of its sum and its length.
 * <p>
 * ·For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
 * Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 */
public class CountSubarraysWithScoreLessThanK {
    //sliding window
    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        int winStart = 0, winEnd = 0;
        long answer = 0;
        while (winEnd < nums.length) {
            sum += nums[winEnd];
            while (winStart <= winEnd && sum * (winEnd - winStart + 1) >= k) {
                sum -= nums[winStart];
                winStart++;
            }
            answer += (winEnd - winStart + 1);
            winEnd++;
        }
        return answer;
    }

    public static void main(String[] args) {
        CountSubarraysWithScoreLessThanK c = new CountSubarraysWithScoreLessThanK();
        assert c.countSubarrays(new int[]{2, 1, 4, 3, 5}, 10) == 6;
        assert c.countSubarrays(new int[]{1, 1, 1}, 5) == 5;
    }
}
