package com.leiqjl;

import java.util.Arrays;

/**
 * 912. Sort an Array - Medium
 * Given an array of integers nums, sort the array in ascending order and return it.
 * <p>
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length / 2 + 1];
        sort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void sort(int[] nums, int l, int r, int[] temp) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(nums, l, m, temp);
            sort(nums, m + 1, r, temp);
            merge(nums, l, m, r, temp);
        }
    }

    private void merge(int[] nums, int l, int m, int r, int[] temp) {
        int len1 = m - l + 1;
        for (int i = 0; i < len1; i++) {
            temp[i] = nums[l + i];
        }
        int i = 0, j = m + 1, k = l;
        while (i < len1 && j <= r) {
            if (temp[i] < nums[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = nums[j++];
            }
        }
        while (i < len1) {
            nums[k++] = temp[i++];
        }
        while (j <= r) {
            nums[k++] = nums[j++];
        }
    }

    public static void main(String[] args) {
        SortAnArray s = new SortAnArray();
        //Input: nums = [5,2,3,1]
        //Output: [1,2,3,5]
        System.out.println(Arrays.toString(s.sortArray(new int[]{5,2,3,1})));
    }
}
