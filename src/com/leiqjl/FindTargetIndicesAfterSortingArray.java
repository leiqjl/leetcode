package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2089. Find Target Indices After Sorting Array - Easy
 * You are given a 0-indexed integer array nums and a target element target.
 * <p>
 * A target index is an index i such that nums[i] == target.
 * <p>
 * Return a list of the target indices of nums after sorting nums in non-decreasing order.
 * If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 */
public class FindTargetIndicesAfterSortingArray {

    //1 <= nums.length <= 100
    //1 <= nums[i], target <= 100
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int less = 0, count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            } else if (num < target) {
                less++;
            }
        }
        while (count-- > 0) {
            result.add(less++);
        }
        return result;
    }
}
