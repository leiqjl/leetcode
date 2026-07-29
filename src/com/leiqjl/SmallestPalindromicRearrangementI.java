package com.leiqjl;

/**
 * 3517. Smallest Palindromic Rearrangement I - Medium
 */
public class SmallestPalindromicRearrangementI {

    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        String middleChar = (n & 1) == 1 ? s.charAt(n / 2) + "" : "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int count = freq[i] / 2;
            while (count > 0) {
                sb.append((char) ('a' + i));
                count--;
            }
        }

        return sb + middleChar + sb.reverse();
    }
}
