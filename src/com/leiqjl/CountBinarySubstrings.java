package com.leiqjl;

/**
 * 696. Count Binary Substrings - Easy
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int count = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                count += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        return count + Math.min(prev, cur);
    }
}
