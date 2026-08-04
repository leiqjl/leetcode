package com.leiqjl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 3731. Find Missing Elements - Easy
 * You are given an integer array nums consisting of unique integers.
 * <p>
 * Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.
 * <p>
 * The smallest and largest integers of the original range are still present in nums.
 * <p>
 * Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.
 */
public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
