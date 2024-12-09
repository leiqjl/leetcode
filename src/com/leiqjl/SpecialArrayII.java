package com.leiqjl;

import java.util.Arrays;

/**
 * 3152. Special Array II - Medium
 */
public class SpecialArrayII {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        boolean isOdd = (nums[0] & 1) == 1;
        nums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            boolean odd = (nums[i] & 1) == 1;
            if (odd == isOdd) {
                nums[i] = i;
            } else {
                nums[i] = nums[i - 1];
            }
            isOdd = odd;
        }
        for (int i = 0; i < queries.length; i++) {
            if (nums[queries[i][1]] <= queries[i][0]) {
                res[i] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpecialArrayII s = new SpecialArrayII();
        //Input: nums = [3,4,1,2,6], queries = [[0,4]]
        //
        //Output: [false]
        assert Arrays.toString(s.isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}})).equals("[false]");
        //Input: nums = [4,3,1,6], queries = [[0,2],[2,3]]
        //
        //Output: [false,true]
        assert Arrays.toString(s.isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})).equals("[false, true]");
    }
}
