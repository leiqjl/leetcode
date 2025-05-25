package com.leiqjl;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words - Medium
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        int len = 0;
        int[][] freq = new int[26][26];
        for (String w : words) {
            int i = w.charAt(0) - 'a';
            int j = w.charAt(1) - 'a';
            if (freq[j][i] > 0) {
                freq[j][i]--;
                len += 4;
                continue;
            }
            freq[i][j]++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i][i] > 0) {
                len += 2;
                break;
            }
        }
        return len;
    }
}