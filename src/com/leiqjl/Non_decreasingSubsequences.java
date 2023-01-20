package com.leiqjl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 491. Non-decreasing Subsequences - Medium
 */
public class Non_decreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
                backtracking(i, nums, new ArrayList<>(), result);
            }
        }
        return result;
    }

    private void backtracking(int s, int[] nums, List<Integer> list, List<List<Integer>> result) {
        list.add(nums[s]);
        if (list.size() > 1) {
            result.add(new ArrayList<>(list));
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = s + 1; i < nums.length; i++) {
            if (!hashSet.contains(nums[i]) && nums[s] <= nums[i]) {
                hashSet.add(nums[i]);
                backtracking(i, nums, list, result);
            }
        }
        list.remove(list.size()-1);
    }
}
