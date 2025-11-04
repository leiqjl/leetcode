package com.leiqjl;

import java.util.Arrays;

/**
 * 3318. Find X-Sum of All K-Long Subarrays I - Medium
 * <p>
 * You are given an array nums of n integers and two integers k and x.
 * <p>
 * The x-sum of an array is calculated by the following procedure:
 * <p>
 * ·Count the occurrences of all elements in the array.
 * ·Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
 * ·Calculate the sum of the resulting array.
 * Note that if an array has less than x distinct elements, its x-sum is the sum of the array.
 * <p>
 * Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].
 */
public class FindX_SumOfAllK_LongSubarraysI {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = sum(nums, x, i, i + k - 1);
        }
        return result;
    }

    private int sum(int[] nums, int x, int l, int r) {
        int sum = 0;
        int[] freq = new int[51];
        int count = 0;
        for (int i = l; i <= r; i++) {
            sum += nums[i];
            if (freq[nums[i]] == 0) {
                count++;
            }
            freq[nums[i]]++;
        }
        if (count < x) {
            return sum;
        }
        sum = 0;
        for (int i = 0; i < x; i++) {
            int maxFreq = -1;
            int max = -1;
            for (int j = 50; j >= 1; j--) {
                if (freq[j] > maxFreq) {
                    maxFreq = freq[j];
                    max = j;
                }
            }
            if (max != -1) {
                sum += max * maxFreq;
                freq[max] = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FindX_SumOfAllK_LongSubarraysI f = new FindX_SumOfAllK_LongSubarraysI();
        assert Arrays.equals(f.findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2), new int[]{6, 10, 12});
        assert Arrays.equals(f.findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2), new int[]{11, 15, 15, 15, 12});
        assert Arrays.equals(f.findXSum(new int[]{50, 50, 50, 50, 50, 50}, 6, 1), new int[]{300});
    }
}
