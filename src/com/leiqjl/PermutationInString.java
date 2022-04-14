package com.leiqjl;

/**
 * 567. Permutation in String - Medium
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {
    //1 <= s1.length, s2.length <= 104
    //s1 and s2 consist of lowercase English letters.
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int[] cnt = new int[26];

        for (int i = 0; i < len1; i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        if (check(cnt)) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            cnt[s2.charAt(i) - 'a']--;
            cnt[s2.charAt(i - len1) - 'a']++;
            if (check(cnt)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] cnt) {
        for (int c : cnt) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
