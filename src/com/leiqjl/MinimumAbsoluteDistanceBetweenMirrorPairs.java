package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 3761. Minimum Absolute Distance Between Mirror Pairs - Medium
 * You are given an integer array nums.
 * <p>
 * A mirror pair is a pair of indices (i, j) such that:
 * <p>
 * ·0 <= i < j < nums.length, and
 * ·reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing, for example reverse(120) = 21.
 * Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices i and j is abs(i - j).
 * <p>
 * If no mirror pair exists, return -1.
 */
public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res = Math.min(res, i - map.get(nums[i]));
            }
            map.put(reverse(nums[i]), i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
