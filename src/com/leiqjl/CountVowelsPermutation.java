package com.leiqjl;

import java.util.Arrays;

/**
 * 1220. Count Vowels Permutation - Hard
 * <p>
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 * <p>
 * - Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * - Each vowel 'a' may only be followed by an 'e'.
 * - Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * - Each vowel 'i' may not be followed by another 'i'.
 * - Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * - Each vowel 'u' may only be followed by an 'a'.
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class CountVowelsPermutation {
    //'a', 'e', 'i', 'o', 'u'
    //time O(n) space O(n)
    public int countVowelPermutation1(int n) {
        int mod = 1000000007;
        long[][] dp = new long[n][5];
        Arrays.fill(dp[0], 1);
        // 0 1
        // 1 02
        // 2 0134
        // 3 24
        // 4 0
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4]) % mod;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][4] = dp[i - 1][0];
        }
        return (int) ((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3] + dp[n - 1][4]) % mod);
    }

    //time O(n) space O(1)
    public int countVowelPermutation(int n) {
        int mod = 1000000007;
        long[] dp = new long[5];
        Arrays.fill(dp, 1);
        while (n > 1) {
            long aVal = dp[1];
            long eVal = (dp[0] + dp[2]) % mod;
            long iVal = (dp[0] + dp[1] + dp[3] + dp[4]) % mod;
            long oVal = (dp[2] + dp[4]) % mod;
            long uVal = dp[0];
            dp[0] = aVal;
            dp[1] = eVal;
            dp[2] = iVal;
            dp[3] = oVal;
            dp[4] = uVal;
            n--;
        }
        return (int) ((dp[0] + dp[1] + dp[2] + dp[3] + dp[4]) % mod);
    }

    public static void main(String[] args) {
        CountVowelsPermutation c = new CountVowelsPermutation();
        //Input: n = 1
        //Output: 5
        //Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
        assert c.countVowelPermutation(1) == 5;
        //Input: n = 2
        //Output: 10
        //Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
        assert c.countVowelPermutation(2) == 10;
        //Input: n = 5
        //Output: 68
        assert c.countVowelPermutation(5) == 68;

        assert c.countVowelPermutation(144) == 18208803;

        assert c.countVowelPermutation(158) == 237753473;
    }
}
