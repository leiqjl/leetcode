package com.leiqjl;

/**
 * 334. Increasing Triplet Subsequence - Medium
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        //Input: nums = [1,2,3,4,5]
        //Output: true
        //Explanation: Any triplet where i < j < k is valid.
        assert i.increasingTriplet(new int[]{1, 2, 3, 4, 5});
        //Input: nums = [5,4,3,2,1]
        //Output: false
        //Explanation: No triplet exists.
        assert !i.increasingTriplet(new int[]{5, 4, 3, 2, 1});
        //Input: nums = [2,1,5,0,4,6]
        //Output: true
        //Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
        assert i.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6});
        //[0,4,2,1,0,-1,-3] false
        assert !i.increasingTriplet(new int[]{0, 4, 2, 1, 0, -1, -3});
        //[20,100,10,12,5,13]
        assert i.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13});
    }
}
