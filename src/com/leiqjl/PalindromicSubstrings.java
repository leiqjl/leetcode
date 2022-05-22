package com.leiqjl;

/**
 * 647. Palindromic Substrings - Medium
 */
public class PalindromicSubstrings {
    int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            checkPalindromicSubstring(s, i, i);
            checkPalindromicSubstring(s, i, i + 1);
        }
        return count;
    }

    private void checkPalindromicSubstring(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
    }
}
