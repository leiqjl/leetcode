package com.leiqjl;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1679. Max Number of K-Sum Pairs - Medium
 */
public class MaxNumberOfKSumPairs {
    // O(nlogn) O(1)
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                left++;
                right--;
                result++;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
    //O(n) O(n)
    public int maxOperations1(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = k - num;
            int count = map.getOrDefault(key, 0);
            if (count > 0) {
                result++;
                map.put(key, count - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return result;
    }

}
