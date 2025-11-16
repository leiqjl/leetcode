package com.leiqjl;

/**
 * 1513. Number of Substrings With Only 1s - Medium
 */
public class NumberOfSubstringsWithOnly1s {
    private static final int MOD = 1_000_000_007;

    public int numSub(String s) {
        long num = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
                num += count;
            } else {
                count = 0;
            }
            if (num >= MOD) {
                num %= MOD;
            }
        }
        return (int) (num % MOD);
    }
}
