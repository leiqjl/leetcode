package com.leiqjl;

/**
 * 2221. Find Triangular Sum of an Array - Medium
 */
public class FindTriangularSumOfAnArray {

    public int triangularSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        System.arraycopy(nums, 0, dp, 0, n);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[j] = (dp[j] + dp[j + 1]) % 10;
            }
        }
        return dp[0];
    }

    /* 2^exp mod 10，周期 4 */
    private static int pow2mod(int exp) {
        int[] tab = {6, 2, 4, 8}; // 2^0≡6, 2^1≡2, 2^2≡4, 2^3≡8
        return tab[exp & 3];
    }

    public static void main(String[] args) {
        FindTriangularSumOfAnArray f = new FindTriangularSumOfAnArray();
        //Input: nums = [1,2,3,4,5]
        //Output: 8
        assert f.triangularSum(new int[]{1, 2, 3, 4, 5}) == 8;
        //Input: nums = [5,2,1,4,6,6,2,1]
        //Output: 1
        assert f.triangularSum(new int[]{5, 2, 1, 4, 6, 6, 2, 1}) == 1;
    }
}
