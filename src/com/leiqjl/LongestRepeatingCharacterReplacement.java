package com.leiqjl;

/**
 * 424. Longest Repeating Character Replacement - Medium
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestRepeatingCharacterReplacement {
    //sliding window
    //end-start+1-maxCount = k
    public int characterReplacement(String s, int k) {
        int maxLen = 0, maxCount = 0;
        int begin = 0, end = 0;
        int[] freq = new int[26];
        while (end < s.length()) {
            freq[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(end) - 'A']);
            if (end - begin + 1 - maxCount > k) {
                freq[s.charAt(begin) - 'A']--;
                begin++;
            }
            maxLen = Math.max(maxLen, end - begin + 1);
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        assert l.characterReplacement("ABAB", 2) == 4;
        assert l.characterReplacement("AABABBA", 1) == 4;
    }
}
