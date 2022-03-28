package com.leiqjl;

/**
 * 33. Search in Rotated Sorted Array - Medium
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int begin = 0, end = n - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > nums[end]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        int rotate = begin;
        begin = 0;
        end = n - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            int rotMid = (mid + rotate) % n;
            if (nums[rotMid] == target) {
                return rotMid;
            } else if (nums[rotMid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        //Input: nums = [4,5,6,7,0,1,2], target = 0
        //Output: 4
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assert s.search(nums, 0) == 4;
        //Input: nums = [4,5,6,7,0,1,2], target = 3
        //Output: -1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        assert s.search(nums1, 3) == -1;
        int[] nums2 = {1};
        assert s.search(nums2, 0) == -1;

    }
}
