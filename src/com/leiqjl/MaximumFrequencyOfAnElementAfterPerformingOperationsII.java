package com.leiqjl;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;

/**
 * 3347. Maximum Frequency of an Element After Performing Operations II - Hard
 * You are given an integer array nums and two integers k and numOperations.
 * <p>
 * You must perform an operation numOperations times on nums, where in each operation you:
 * <p>
 * · Select an index i that was not selected in any previous operations.
 * · Add an integer in the range [-k, k] to nums[i].
 * Return the maximum possible frequency of any element in nums after performing the operations.
 */
public class MaximumFrequencyOfAnElementAfterPerformingOperationsII {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^9
    //0 <= k <= 10^9
    //0 <= numOperations <= nums.length
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

    public int maxFrequency1(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        Set<Integer> modes = new TreeSet<>();

        Consumer<Integer> addMode = value -> {
            modes.add(value);
            if (value - k >= nums[0]) {
                modes.add(value - k);
            }
            if (value + k <= nums[nums.length - 1]) {
                modes.add(value + k);
            }
        };

        int lastNumIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastNumIndex]) {
                numCount.put(nums[lastNumIndex], i - lastNumIndex);
                ans = Math.max(ans, i - lastNumIndex);
                addMode.accept(nums[lastNumIndex]);
                lastNumIndex = i;
            }
        }

        numCount.put(nums[lastNumIndex], nums.length - lastNumIndex);
        ans = Math.max(ans, nums.length - lastNumIndex);
        addMode.accept(nums[lastNumIndex]);

        IntUnaryOperator leftBound = value -> {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < value) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        };

        IntUnaryOperator rightBound = value -> {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums[mid] > value) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        };

        for (int mode : modes) {
            int l = leftBound.applyAsInt(mode - k);
            int r = rightBound.applyAsInt(mode + k);
            int tempAns;
            if (numCount.containsKey(mode)) {
                tempAns = Math.min(
                        r - l + 1,
                        numCount.get(mode) + numOperations
                );
            } else {
                tempAns = Math.min(r - l + 1, numOperations);
            }
            ans = Math.max(ans, tempAns);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumFrequencyOfAnElementAfterPerformingOperationsII m = new MaximumFrequencyOfAnElementAfterPerformingOperationsII();
        assert m.maxFrequency(new int[]{1, 4, 5}, 1, 2) == 2;
        assert m.maxFrequency(new int[]{5, 11, 20, 20}, 5, 1) == 2;
    }
}
