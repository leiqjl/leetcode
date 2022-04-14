package com.leiqjl;

import java.util.HashMap;

/**
 * 76. Minimum Window Substring - Hard
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int left = 0, right = 0, count = 0;
        int min = Integer.MAX_VALUE, sub = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            char cr = s.charAt(right);
            if (map.containsKey(cr)) {
                int crCount = map.get(cr) - 1;
                map.put(cr, crCount);
                if (crCount >= 0) {
                    count++;
                }
            }
            while (count == t.length()) {
                if ((right - left + 1) < min) {
                    min = right - left + 1;
                    sub = left;
                }
                char cl = s.charAt(left);
                if (map.containsKey(cl)) {
                    int clCount = map.get(cl) + 1;
                    map.put(cl, clCount);
                    if (clCount > 0) {
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(sub, sub + min);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        //Input: s = "ADOBECODEBANC", t = "ABC"
        //Output: "BANC"
        String s = "ADOBECODEBANC";
        String t = "ABC";
        assert m.minWindow(s, t).equals("BANC");
        String s1 = "a";
        String t1 = "aa";
        assert m.minWindow(s1, t1).equals("");
    }
}
