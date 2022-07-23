package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self - Hard
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        int[] counts = new int[n];
        mergeSort(nums, indexes, counts, 0, n - 1);
        List<Integer> result = new ArrayList<>(n);
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }

    private void mergeSort(int[] nums, int[] indexes, int[] counts, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, indexes, counts, left, mid);
        mergeSort(nums, indexes, counts, mid + 1, right);

        merge(nums, indexes, counts, left, right);
    }

    private void merge(int[] nums, int[] indexes, int[] counts, int left, int right) {
        int mid = (left + right) / 2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int[] tmp = new int[right - left + 1];
        int rightCount = 0;
        int idx = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[indexes[leftIndex]] > nums[indexes[rightIndex]]) {
                rightCount++;

                tmp[idx++] = indexes[rightIndex++];
            } else {
                counts[indexes[leftIndex]] += rightCount;

                tmp[idx++] = indexes[leftIndex++];
            }
        }
        while (leftIndex <= mid) {
            counts[indexes[leftIndex]] += rightCount;

            tmp[idx++] = indexes[leftIndex++];
        }
        while (rightIndex <= right) {
            tmp[idx++] = indexes[rightIndex++];
        }

        for (int i = left; i <= right; i++) {
            indexes[i] = tmp[i - left];
        }
    }
}
