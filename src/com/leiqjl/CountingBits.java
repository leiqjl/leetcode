package com.leiqjl;

/**
 * 338. Counting Bits - Easy
 * <p>
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits {

    /**
     * 0 1 2 3 4 5 6 7
     * 0 1 1 2 1 2 2 3
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            //ans[n] = ans[n/2] + n%2
            System.out.println(i>>1);
            System.out.println(i&1);
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

}
