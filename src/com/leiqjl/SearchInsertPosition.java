package com.leiqjl;

/**
 * 35. Search Insert Position - Easy
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition {

//    public int searchInsert(int[] nums, int target) {
//        int i;
//        for (i = 0; i < nums.length; i++) {
//            if (nums[i] >= target) {
//                break;
//            }
//        }
//        return i;
//    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        //Input: nums = [1,3,5,6], target = 5
        //Output: 2
        assert s.searchInsert(nums, 5) == 2;
        //Input: nums = [1,3,5,6], target = 2
        //Output: 1
        assert s.searchInsert(nums, 2) == 1;
        //Input: nums = [1,3,5,6], target = 7
        //Output: 4
        assert s.searchInsert(nums, 7) == 4;
    }

}
