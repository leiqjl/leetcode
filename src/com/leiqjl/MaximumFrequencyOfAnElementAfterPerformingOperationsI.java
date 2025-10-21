package com.leiqjl;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 3346. Maximum Frequency of an Element After Performing Operations I - Medium
 * You are given an integer array nums and two integers k and numOperations.
 * <p>
 * You must perform an operation numOperations times on nums, where in each operation you:
 * <p>
 * · Select an index i that was not selected in any previous operations.
 * · Add an integer in the range [-k, k] to nums[i].
 * Return the maximum possible frequency of any element in nums after performing the operations.
 */
public class MaximumFrequencyOfAnElementAfterPerformingOperationsI {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int answer = 0, n = nums.length;
        int winStart = 0, winEnd = 0;
        while (winEnd < n) {
            int mid = (nums[winStart] + nums[winEnd]) / 2;
            while (mid - nums[winStart] > k || nums[winEnd] - mid > k) {
                winStart++;
                mid = (nums[winStart] + nums[winEnd]) / 2;
            }
            answer = Math.max(answer, Math.min(winEnd - winStart + 1, numOperations));
            winEnd++;
        }
        winStart = 0;
        winEnd = 0;
        for (int i = 0; i < n; i++) {
            while (nums[i] - nums[winStart] > k) {
                winStart++;
            }
            while (winEnd < n && nums[winEnd] - nums[i] <= k) {
                winEnd++;
            }
            int freq = freqMap.get(nums[i]);
            answer = Math.max(answer, Math.min(winEnd - winStart - freq, numOperations) + freq);
        }

        return answer;
    }

    public static void main(String[] args) {
        MaximumFrequencyOfAnElementAfterPerformingOperationsI m = new MaximumFrequencyOfAnElementAfterPerformingOperationsI();
        assert m.maxFrequency(new int[]{1, 4, 5}, 1, 2) == 2;
        assert m.maxFrequency(new int[]{5, 11, 20, 20}, 5, 1) == 2;
    }
}
