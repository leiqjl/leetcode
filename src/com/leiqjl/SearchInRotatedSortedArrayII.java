package com.leiqjl;

/**
 * 81. Search in Rotated Sorted Array II - Medium
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[begin] == nums[mid]) {
                begin++;
            } else if (nums[begin] < nums[mid]) {
                if ((nums[begin] <= target) && (target < nums[mid])) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                if ((nums[mid] < target) && (target <= nums[end])) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
        //Input: nums = [2,5,6,0,0,1,2], target = 0
        //Output: true
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        assert s.search(nums, 0);
        //Input: nums = [2,5,6,0,0,1,2], target = 3
        //Output: false
        assert !s.search(nums, 3);
        int[] nums1 = {1, 1, 1, 3, 1, 1, 1, 1, 1, 1};
        assert s.search(nums1, 3);
    }
}
