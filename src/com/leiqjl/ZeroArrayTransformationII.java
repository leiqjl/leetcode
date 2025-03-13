package com.leiqjl;

/**
 * 3356. Zero Array Transformation II - Medium
 * You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].
 * <p>
 * Each queries[i] represents the following action on nums:
 * <p>
 * ·Decrement the value at each index in the range [li, ri] in nums by at most vali.
 * ·The amount by which each value is decremented can be chosen independently for each index.
 * A Zero Array is an array with all its elements equal to 0.
 * <p>
 * Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.
 */
public class ZeroArrayTransformationII {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //0 <= nums[i] <= 5 * 10^5
    //1 <= queries.length <= 10^5
    //queries[i].length == 3
    //0 <= li <= ri < nums.length
    //1 <= vali <= 5
    public int minZeroArray(int[] nums, int[][] queries) {
        int k = 0, sum = 0;
        int[] diff = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            while (sum + diff[i] < nums[i]) {
                if (k == queries.length) {
                    return -1;
                }
                int l = queries[k][0];
                int r = queries[k][1];
                int val = queries[k][2];
                if (r >= i) {
                    diff[Math.max(i, l)] += val;
                    diff[r + 1] -= val;
                }
                k++;
            }
            sum += diff[i];
        }
        return k;
    }


    public static void main(String[] args) {
        ZeroArrayTransformationII z = new ZeroArrayTransformationII();
        assert z.minZeroArray(new int[]{2, 0, 2}, new int[][]{{0, 2, 1}, {0, 2, 1}, {1, 1, 3}}) == 2;
        assert z.minZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3, 2}, {0, 2, 1}}) == -1;
    }
}
