package com.leiqjl;

/**
 * 242. Valid Anagram - Easy
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class ValidAnagram {
    //1 <= s.length, t.length <= 5 * 10^4
    //s and t consist of lowercase English letters.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[t.charAt(i) - 'a']--;
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i : cnt) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
