package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges - Easy
 * <p>
 * You are given a sorted unique integer array nums.
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * - "a->b" if a != b
 * - "a" if a == b
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int begin = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
                end++;
            }
            if (begin != end) {
                result.add(nums[begin] + "->" + nums[end]);
            } else {
                result.add(String.valueOf(nums[begin]));
            }
            end++;
            begin = end;
        }
        return result;
    }
}
