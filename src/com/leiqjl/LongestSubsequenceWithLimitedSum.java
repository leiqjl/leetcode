package com.leiqjl;

import java.util.Arrays;

/**
 * 2389. Longest Subsequence With Limited Sum - Easy
 */
public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(nums, 0, nums.length - 1, queries[i]);
        }
        return result;
    }

    private int binarySearch(int[] a, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = a[mid];

            if (midVal < target)
                left = mid + 1;
            else if (midVal > target)
                right = mid - 1;
            else
                return mid;
        }
        return left;
    }

    public static void main(String[] args) {
        LongestSubsequenceWithLimitedSum l = new LongestSubsequenceWithLimitedSum();
        assert Arrays.toString(l.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})).equals("[1, 3, 4]");
        assert Arrays.toString(l.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})).equals("[0]");
    }
}
