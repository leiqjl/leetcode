package com.leiqjl;

import java.util.Arrays;

/**
 * 2161. Partition Array According to Given Pivot - Medium
 * You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
 * <p>
 * ·Every element less than pivot appears before every element greater than pivot.
 * ·Every element equal to pivot appears in between the elements less than and greater than pivot.
 * ·The relative order of the elements less than pivot and the elements greater than pivot is maintained.
 * ·More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
 * Return nums after the rearrangement.
 */
public class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                result[l++] = nums[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                result[r--] = nums[i];
            }
        }
        for (int i = l; i <= r; i++) {
            result[i] = pivot;
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionArrayAccordingToGivenPivot p = new PartitionArrayAccordingToGivenPivot();
        //Input: nums = [9,12,5,10,14,3,10], pivot = 10
        //Output: [9,5,3,10,10,12,14]
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        assert Arrays.toString(p.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)).equals("[9, 5, 3, 10, 10, 12, 14]");
        //Input: nums = [-3,4,3,2], pivot = 2
        //Output: [-3,2,4,3]
        assert Arrays.toString(p.pivotArray(new int[]{-3, 4, 3, 2}, 2)).equals("[-3, 2, 4, 3]");
    }
}
