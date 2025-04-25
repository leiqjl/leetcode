package com.leiqjl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2845. Count of Interesting Subarrays - Medium
 * You are given a 0-indexed integer array nums, an integer modulo, and an integer k.
 * <p>
 * Your task is to find the count of subarrays that are interesting.
 * <p>
 * A subarray nums[l..r] is interesting if the following condition holds:
 * <p>
 * ·Let cnt be the number of indices i in the range [l, r] such that nums[i] % modulo == k. Then, cnt % modulo == k.
 * Return an integer denoting the count of interesting subarrays.
 * <p>
 * Note: A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class CountOfInterestingSubarrays {

    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^9
    //1 <= modulo <= 10^9
    //0 <= k < modulo
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long answer = 0;
        for (int num : nums) {
            if (num % modulo == k) {
                prefixSum++;
            }
            answer = answer + map.getOrDefault((prefixSum - k + modulo) % modulo, 0);
            map.put(prefixSum % modulo, map.getOrDefault(prefixSum % modulo, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        CountOfInterestingSubarrays c = new CountOfInterestingSubarrays();
        //Input: nums = [3,2,4], modulo = 2, k = 1
        //Output: 3
        assert c.countInterestingSubarrays(List.of(3, 2, 4), 2, 1) == 3;
        //Input: nums = [3,1,9,6], modulo = 3, k = 0
        //Output: 2
        assert c.countInterestingSubarrays(List.of(3, 1, 9, 6), 3, 0) == 2;
    }
}
