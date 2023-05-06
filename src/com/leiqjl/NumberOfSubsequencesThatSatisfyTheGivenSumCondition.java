package com.leiqjl;

import java.util.Arrays;

/**
 * 1498. Number of Subsequences That Satisfy the Given Sum Condition - Medium
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^6
    //1 <= target <= 10^6
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        int l = 0, r = nums.length - 1;
        int result = 0;
        int[] powArray = new int[nums.length];
        powArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            powArray[i] = powArray[i - 1] * 2 % mod;
        }
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                result = (result + powArray[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfyTheGivenSumCondition n = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
        assert n.numSubseq(new int[]{3, 5, 6, 7}, 9) == 4;
        assert n.numSubseq(new int[]{3, 3, 6, 8}, 10) == 6;
        assert n.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12) == 61;
        assert n.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22) == 272187084;
    }
}
