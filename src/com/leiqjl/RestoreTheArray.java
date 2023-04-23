package com.leiqjl;

/**
 * 1416. Restore The Array - Hard
 * A program was supposed to print an array of integers.
 * The program forgot to print whitespaces and the array is printed as a string of digits s and all we know is that
 * all integers in the array were in the range [1, k] and there are no leading zeros in the array.
 * <p>
 * Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the mentioned program.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 */
public class RestoreTheArray {

    public int numberOfArrays(String s, int k) {
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            for (int j = i + 1; j <= n; j++) {
                long temp = Long.parseLong(s.substring(i, j));
                if (temp > k) {
                    break;
                }
                dp[i] = (dp[i] + dp[j]) % mod;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        RestoreTheArray r = new RestoreTheArray();
        //[1000]
        assert r.numberOfArrays("1000", 10000) == 1;

        assert r.numberOfArrays("1000", 10) == 0;
        //[1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]
        assert r.numberOfArrays("1317", 2000) == 8;
        assert r.numberOfArrays("2020", 30) == 1;
        assert r.numberOfArrays("1111111111111", 1000000000) == 4076;
    }
}
