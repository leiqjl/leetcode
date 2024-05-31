package com.leiqjl;

/**
 * 153. Find Minimum in Rotated Sorted Array - Medium
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > nums[end]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[begin];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
        //Input: nums = [3,4,5,1,2]
        //Output: 1
        //Explanation: The original array was [1,2,3,4,5] rotated 3 times.
        assert f.findMin(new int[]{3, 4, 5, 1, 2}) == 1;
        //Input: nums = [4,5,6,7,0,1,2]
        //Output: 0
        //Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
        assert f.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}) == 0;
        //Input: nums = [11,13,15,17]
        //Output: 11
        //Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
        assert f.findMin(new int[]{11, 13, 15, 17}) == 11;
    }
}
