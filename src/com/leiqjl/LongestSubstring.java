package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Input:"abcabcbb"
 * Output:3
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(n);
        int i = 0, j = 0, result = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            map.put(c, j);
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }

    //map->array
    public int lengthOfLongestSubstring(String s) {
        int[] r = new int[128];
        int i = 0, j = 0, result = 0;
        for (char c : s.toCharArray()) {
            i = Math.max(i, r[c]);
            j++;
            r[c] = j;
            result = Math.max(result, j-i);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("dvdf"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abba"));
    }
}
