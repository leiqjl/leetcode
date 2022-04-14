package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String - Medium
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class FindAllAnagramsInAString {

    //1 <= s.length, p.length <= 3 * 10^4
    //s and p consist of lowercase English letters.
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int len1 = p.length();
        int len2 = s.length();
        int[] cnt = new int[26];

        for (int i = 0; i < len1; i++) {
            cnt[p.charAt(i) - 'a']++;
            cnt[s.charAt(i) - 'a']--;
        }
        if (check(cnt)) {
            result.add(0);
        }
        for (int i = len1; i < len2; i++) {
            cnt[s.charAt(i) - 'a']--;
            cnt[s.charAt(i - len1) - 'a']++;
            if (check(cnt)) {
                result.add(i - len1 + 1);
            }
        }
        return result;
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
