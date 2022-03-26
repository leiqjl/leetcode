package com.leiqjl;

/**
 * 704. Binary Search - Easy
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
