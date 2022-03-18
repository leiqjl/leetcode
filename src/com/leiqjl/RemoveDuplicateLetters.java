package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. Remove Duplicate Letters - Medium
 * <p>
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
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

    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        //Input: s = "bcabc"
        //Output: "abc"
        String s = "bcabc";
        assert r.removeDuplicateLetters(s).equals("abc");
        //Input: s = "cbacdcbc"
        //Output: "acdb"
        String s1 = "cbacdcbc";
        assert r.removeDuplicateLetters(s1).equals("acdb");
    }

}
