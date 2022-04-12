package com.leiqjl;

import java.util.HashSet;

/**
 * 409. Longest Palindrome - Easy
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (hashSet.contains(c)) {
                hashSet.remove(c);
            } else {
                hashSet.add(c);
            }
        }
        return hashSet.size() == 0 ? s.length() : s.length() - hashSet.size() + 1;
    }
}
