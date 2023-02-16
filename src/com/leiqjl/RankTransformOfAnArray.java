package com.leiqjl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. Rank Transform of an Array - Easy
 */
public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums = Arrays.copyOf(arr, arr.length);
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, map.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            nums[i] = map.get(arr[i]);
        }
        return nums;
    }
}
