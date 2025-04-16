package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 2537. Count the Number of Good Subarrays - Medium
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * <p>
 * A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class CountTheNumberOfGoodSubarrays {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //1 <= nums[i], k <= 10^9
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int pairs = 0;
        long count = 0;
        int winStart = 0, winEnd = 0;
        while (winEnd < nums.length) {
            int freq = freqMap.getOrDefault(nums[winEnd], 0);
            pairs += freq;
            freqMap.put(nums[winEnd], freq + 1);
            while (pairs >= k) {
                count += nums.length - winEnd;
                freq = freqMap.getOrDefault(nums[winStart], 0);
                freq--;
                pairs -= freq;
                freqMap.put(nums[winStart], freq);
                winStart++;
            }
            winEnd++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountTheNumberOfGoodSubarrays c = new CountTheNumberOfGoodSubarrays();
        //Input: nums = [1,1,1,1,1], k = 10
        //Output: 1
        assert c.countGood(new int[]{1, 1, 1, 1, 1}, 10) == 1;
        //Input: nums = [3,1,4,3,2,2,4], k = 2
        //Output: 4
        //Explanation: There are 4 different good subarrays:
        //- [3,1,4,3,2,2] that has 2 pairs.
        //- [3,1,4,3,2,2,4] that has 3 pairs.
        //- [1,4,3,2,2,4] that has 2 pairs.
        //- [4,3,2,2,4] that has 2 pairs.
        assert c.countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2) == 4;
    }
}
