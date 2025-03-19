package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence - Easy
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 */
public class LongestHarmoniousSubsequence {

    //Constraints:
    //
    //1 <= nums.length <= 2 * 10^4
    //-10^9 <= nums[i] <= 10^9
    public int findLHS(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                max = Math.max(max, map.get(num) + map.get(num + 1));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        LongestHarmoniousSubsequence l = new LongestHarmoniousSubsequence();
        assert l.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}) == 5;
        assert l.findLHS(new int[]{1, 2, 3, 4}) == 2;
        assert l.findLHS(new int[]{1, 1, 1, 1}) == 0;
    }
}
