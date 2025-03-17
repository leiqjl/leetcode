package com.leiqjl;

import java.util.Arrays;

/**
 * 395. Longest Substring with At Least K Repeating Characters - Medium
 * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
 * <p>
 * if no such substring exists, return 0.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    //Constraints:
    //
    //1 <= s.length <= 10^4
    //s consists of only lowercase English letters.
    //1 <= k <= 10^5
    //sliding window
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int[] freq = new int[26];
        int uniqueCount = 0;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                uniqueCount++;
            }
            freq[c - 'a']++;
        }
        for (int unique = 1; unique <= uniqueCount; unique++) {
            Arrays.fill(freq, 0);
            int begin = 0, end = 0;
            int curUnique = 0, count = 0;
            int index;
            while (end < s.length()) {
                if (curUnique <= unique) {
                    index = s.charAt(end) - 'a';
                    if (freq[index] == 0) {
                        curUnique++;
                    }
                    freq[index]++;
                    if (freq[index] == k) {
                        count++;
                    }
                    end++;
                } else {
                    index = s.charAt(begin) - 'a';
                    if (freq[index] == k) {
                        count--;
                    }
                    freq[index]--;
                    if (freq[index] == 0) {
                        curUnique--;
                    }
                    begin++;
                }
                if (curUnique == unique && count == unique) {
                    maxLen = Math.max(maxLen, end - begin);
                }
            }
        }
        return maxLen;
    }

    public int longestSubstring1(String s, int k) {
        return getMaxLength(0, s.length(), s, k);
    }

    private int getMaxLength(int begin, int end, String s, int k) {
        if (end < k) {
            return 0;
        }
        int[] freq = new int[26];
        for (int i = begin; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = begin; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] >= k) {
                continue;
            }
            int temp = i + 1;
            while (temp < end && freq[s.charAt(temp) - 'a'] < k) {
                temp++;
            }
            return Math.max(getMaxLength(begin, i, s, k), getMaxLength(temp, end, s, k));
        }
        return (end - begin);
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters l = new LongestSubstringWithAtLeastKRepeatingCharacters();
        String s = "aaabb";
        int k = 3;
        assert l.longestSubstring(s, k) == 3;
        s = "ababbc";
        k = 2;
        assert l.longestSubstring(s, k) == 5;
    }
}
