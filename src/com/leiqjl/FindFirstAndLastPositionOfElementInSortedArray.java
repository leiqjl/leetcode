package com.leiqjl;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array - Hard
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] != target) {
            return result;
        }
        result[0] = l;
        r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2 + 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        result[1] = r;
        return result;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        //Input: nums = [5,7,7,8,8,10], target = 8
        //Output: [3,4]
        int[] nums = {5, 7, 7, 8, 8, 10};
        assert Arrays.equals(f.searchRange(nums, 8), new int[]{3, 4});
        //Input: nums = [5,7,7,8,8,10], target = 6
        //Output: [-1,-1]
        assert Arrays.equals(f.searchRange(nums, 6), new int[]{-1, -1});
        //Input: nums = [], target = 0
        //Output: [-1,-1]
        assert Arrays.equals(f.searchRange(new int[]{}, 0), new int[]{-1, -1});
    }

}
