package com.leiqjl;

/**
 * 1524. Number of Sub-arrays With Odd Sum - Medium
 * <p>
 * Given an array of integers arr, return the number of subarrays with an odd sum.
 * <p>
 * Since the answer can be very large, return it modulo 10^9 + 7.
 */
public class NumberOfSub_arraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 1, sum = 0, res = 0, mod = 1000000007;
        for (int num : arr) {
            sum += num;
            if ((sum & 1) == 1) {
                odd++;
                res = (res + even) % mod;
            } else {
                even++;
                res = (res + odd) % mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSub_arraysWithOddSum n = new NumberOfSub_arraysWithOddSum();
        //Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
        //All sub-arrays sum are [1,4,9,3,8,5].
        //Odd sums are [1,9,3,5] so the answer is 4.
        assert n.numOfSubarrays(new int[]{1, 3, 5}) == 4;
        assert n.numOfSubarrays(new int[]{2, 4, 6}) == 0;
        assert n.numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}) == 16;
    }
}
