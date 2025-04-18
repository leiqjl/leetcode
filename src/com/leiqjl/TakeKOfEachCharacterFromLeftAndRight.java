package com.leiqjl;

/**
 * 2516. Take K of Each Character From Left and Right - Medium
 * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute,
 * you may take either the leftmost character of s, or the rightmost character of s.
 * <p>
 * Return the minimum number of minutes needed for you to take at least k of each character,
 * or return -1 if it is not possible to take k of each character.
 */
public class TakeKOfEachCharacterFromLeftAndRight {
    public int takeCharacters(String s, int k) {
        char[] charArray = s.toCharArray();
        int[] freq = new int[3];
        for (char c : charArray) {
            freq[c - 'a']++;
        }
        for (int f : freq) {
            if (f < k) {
                return -1;
            }
        }
        int maxLen = 0;
        int winEnd = 0, winStart = 0;
        while (winEnd < s.length()) {
            char c = charArray[winEnd];
            freq[c - 'a']--;
            while (freq[c - 'a'] < k) {
                freq[charArray[winStart] - 'a']++;
                winStart++;
            }
            maxLen = Math.max(maxLen, winEnd - winStart + 1);
            winEnd++;
        }
        return s.length() - maxLen;
    }

    public static void main(String[] args) {
        TakeKOfEachCharacterFromLeftAndRight t = new TakeKOfEachCharacterFromLeftAndRight();
        assert t.takeCharacters("aabaaaacaabc", 2) == 8;
        assert t.takeCharacters("a", 1) == -1;
        assert t.takeCharacters("abc", 1) == 3;
    }
}
