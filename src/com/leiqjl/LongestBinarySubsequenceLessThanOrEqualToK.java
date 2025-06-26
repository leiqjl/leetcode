package com.leiqjl;

/**
 * 2311. Longest Binary Subsequence Less Than or Equal to K - Medium
 */
public class LongestBinarySubsequenceLessThanOrEqualToK {

    public int longestSubsequence(String s, int k) {
        int count = 0;
        int cur = 0, base = 1;
        int idx = s.length() - 1;
        while (idx >= 0 && cur + base <= k) {
            if (s.charAt(idx) == '1') {
                cur += base;
            }
            count++;
            base <<= 1;
            idx--;
        }
        while (idx >= 0) {
            if (s.charAt(idx) == '0') {
                count++;
            }
            idx--;
        }
        return count;
    }

    public static void main(String[] args) {
        LongestBinarySubsequenceLessThanOrEqualToK l = new LongestBinarySubsequenceLessThanOrEqualToK();
        assert l.longestSubsequence("1001010", 5) == 5;
        assert l.longestSubsequence("00101001", 1) == 6;
        assert l.longestSubsequence("000101010011011001011101111000111111100001011000000100010000111100000011111001000111100111101001111001011101001011011101001011011001111111010011100011110111010000010000010111001001111101100001111", 300429827) == 108;
    }
}
