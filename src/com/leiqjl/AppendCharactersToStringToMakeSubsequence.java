package com.leiqjl;

/**
 * 2486. Append Characters to String to Make Subsequence - Medium
 * You are given two strings s and t consisting of only lowercase English letters.
 * Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 */
public class AppendCharactersToStringToMakeSubsequence {

    public int appendCharacters(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            if (j == t.length()) {
                return 0;
            }
        }
        return t.length() - j;
    }

    public static void main(String[] args) {
        AppendCharactersToStringToMakeSubsequence a = new AppendCharactersToStringToMakeSubsequence();
        //Input: s = "coaching", t = "coding"
        //Output: 4
        assert a.appendCharacters("coaching", "coding") == 4;
        //Input: s = "abcde", t = "a"
        //Output: 0
        assert a.appendCharacters("abcde", "a") == 0;
        //Input: s = "z", t = "abcde"
        //Output: 5
        assert a.appendCharacters("z", "abcde") == 5;
    }
}
