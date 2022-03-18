package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  1081. Smallest Subsequence of Distinct Characters - Medium
 *  Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
 */
public class SmallestSubsequenceOfDistinctCharacters {
    /**
     * @see RemoveDuplicateLetters#removeDuplicateLetters(String s)
     */
    public String smallestSubsequence(String s) {
        Deque<Integer> deque = new ArrayDeque<>(s.length());
        int[] idx = new int[26], used = new int[26];
        for (int i = 0; i < s.length(); i++) {
            idx[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            if (used[c]++ > 0) {
                continue;
            }
            while (!deque.isEmpty() && deque.getLast() > c && i < idx[deque.getLast()]) {
                used[deque.removeLast()] = 0;
            }
            deque.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : deque) {
            sb.append((char)('a'+i));
        }

        return sb.toString();
    }
}
