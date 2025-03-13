package com.leiqjl;

/**
 * 3355. Zero Array Transformation I - Medium
 * You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].
 *
 * For each queries[i]:
 *
 * ·Select a subset of indices within the range [li, ri] in nums.
 * ·Decrement the values at the selected indices by 1.
 * A Zero Array is an array where all elements are equal to 0.
 *
 * Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.
 */
public class ZeroArrayTransformationI {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //0 <= nums[i] <= 10^5
    //1 <= queries.length <= 10^5
    //queries[i].length == 2
    //0 <= li <= ri < nums.length
    public boolean isZeroArray(int[] nums, int[][] queries) {

        int[] diff = new int[nums.length + 1];
        for (int[] query : queries) {
            diff[query[0]] += 1;
            diff[query[1] + 1] -= 1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += diff[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ZeroArrayTransformationI z = new ZeroArrayTransformationI();
        //Input: nums = [1,0,1], queries = [[0,2]]
        //Output: true
        assert z.isZeroArray(new int[]{1, 0, 1}, new int[][]{{0, 2}});
        //Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]
        //Output: false
        assert !z.isZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3}, {0, 2}});
    }
}
