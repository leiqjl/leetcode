package com.leiqjl;

import java.util.Arrays;

/**
 * 2657. Find the Prefix Common Array of Two Arrays - Medium
 * You are given two 0-indexed integer permutations A and B of length n.
 * <p>
 * A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
 * <p>
 * Return the prefix common array of A and B.
 * <p>
 * A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
 */
public class FindThePrefixCommonArrayOfTwoArrays {
    //Constraints:
    //
    //1 <= A.length == B.length == n <= 50
    //1 <= A[i],  B[i] <= n
    //It is guaranteed that A and B are both a permutation of n integers.
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        long mask = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            mask ^= (1L << A[i]);
            if ((mask & (1L << A[i])) == 0) {
                count++;
            }
            mask ^= (1L << B[i]);
            if ((mask & (1L << B[i])) == 0) {
                count++;
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        FindThePrefixCommonArrayOfTwoArrays f = new FindThePrefixCommonArrayOfTwoArrays();
        assert "[0, 2, 3, 4]".equals(Arrays.toString(f.findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})));
        assert "[0, 1, 3]".equals(Arrays.toString(f.findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2})));
        assert "[0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 5, 6, 7, 8, 9, 10, 11, 11, 12, 13, 15, 16, 18, 20, 22, 24, 25, 27, 29, 31, 33]".equals(Arrays.toString(f.findThePrefixCommonArray(new int[]{20, 2, 14, 19, 31, 9, 30, 13, 17, 33, 10, 3, 26, 28, 5, 8, 6, 29, 22, 21, 23, 4, 1, 27, 24, 11, 12, 18, 7, 25, 32, 16, 15}, new int[]{7, 1, 3, 5, 11, 2, 16, 26, 4, 13, 22, 23, 31, 9, 18, 19, 17, 8, 32, 12, 24, 25, 20, 28, 6, 33, 14, 30, 15, 21, 10, 29, 27})));
    }
}
