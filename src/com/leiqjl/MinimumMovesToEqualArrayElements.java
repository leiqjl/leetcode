package com.leiqjl;

/**
 * 453. Minimum Moves to Equal Array Elements - Medium
 * <p>
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * <p>
 * In one move, you can increment n - 1 elements of the array by 1.
 */
public class MinimumMovesToEqualArrayElements {
    //increase n-1 elements expect max == decrease max to min
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int count = 0;
        for (int num : nums) {
            count += (num - min);
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElements m = new MinimumMovesToEqualArrayElements();
        //Input: nums = [1,2,3]
        //Output: 3
        //Explanation: Only three moves are needed (remember each move increments two elements):
        //[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
        int[] nums = {1, 2, 3};
        assert m.minMoves(nums) == 3;
        //Input: nums = [1,1,1]
        //Output: 0
        int[] nums1 = {1, 1, 1};
        assert m.minMoves(nums1) == 0;
    }
}
