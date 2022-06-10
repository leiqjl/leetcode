package com.leiqjl;

/**
 * 3. Longest Substring Without Repeating Characters - Medium
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int l = 0, r = 0, len = 0;
        for (char c : s.toCharArray()) {
            l = Math.max(l, map[c]);
            r++;
            map[c] = r;
            len = Math.max(len, r - l);
        }
        return len;
    }

}
