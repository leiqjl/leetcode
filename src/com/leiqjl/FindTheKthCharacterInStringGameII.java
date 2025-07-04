package com.leiqjl;

/**
 * 3307. Find the K-th Character in String Game II - Hard
 */
public class FindTheKthCharacterInStringGameII {
    // 1  1xxxx = xxxx + 1
    // 0  1xxxx = xxxx
    public char kthCharacter(long k, int[] operations) {
        int ans = 0;
        k--;
        for (int i = 63 - Long.numberOfLeadingZeros(k); i >= 0; i--) {
            if (((k >> i) & 1) == 1) {
                ans += operations[i];
            }
        }
        ans %= 26;
        return (char) ('a' + ans);
    }
}
