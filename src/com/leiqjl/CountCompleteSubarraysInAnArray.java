package com.leiqjl;

import java.util.Arrays;

/**
 * 2799. Count Complete Subarrays in an Array - Medium
 * You are given an array nums consisting of positive integers.
 * <p>
 * We call a subarray of an array complete if the following condition is satisfied:
 * <p>
 * ·The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
 * Return the number of complete subarrays.
 * <p>
 * A subarray is a contiguous non-empty part of an array.
 */
public class CountCompleteSubarraysInAnArray {
    //Constraints:
    //
    //1 <= nums.length <= 1000
    //1 <= nums[i] <= 2000
    public int countCompleteSubarrays(int[] nums) {
        int[] freq = new int[2001];
        int count = 0;
        for (int num : nums) {
            freq[num]++;
            if (freq[num] == 1) {
                count++;
            }
        }
        Arrays.fill(freq, 0);
        int answer = 0;
        int winStart = 0, winEnd = 0;
        while (winEnd < nums.length) {
            freq[nums[winEnd]]++;
            if (freq[nums[winEnd]] == 1) {
                count--;
            }
            while (count == 0) {
                answer += nums.length - winEnd;
                freq[nums[winStart]]--;
                if (freq[nums[winStart]] == 0) {
                    count++;
                }
                winStart++;
            }
            winEnd++;
        }
        return answer;
    }

    public static void main(String[] args) {
        CountCompleteSubarraysInAnArray c = new CountCompleteSubarraysInAnArray();
        assert c.countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}) == 4;
        assert c.countCompleteSubarrays(new int[]{5, 5, 5, 5}) == 10;
    }
}
