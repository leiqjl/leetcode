package com.leiqjl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2014. Longest Subsequence Repeated k Times - Hard
 * You are given a string s of length n, and an integer k. You are tasked to find the longest subsequence repeated k times in string s.
 * <p>
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 * <p>
 * A subsequence seq is repeated k times in the string s if seq * k is a subsequence of s, where seq * k represents a string constructed by concatenating seq k times.
 * <p>
 * ·For example, "bba" is repeated 2 times in the string "bababcba", because the string "bbabba", constructed by concatenating "bba" 2 times, is a subsequence of the string "bababcba".
 * Return the longest subsequence repeated k times in string s. If multiple such subsequences are found, return the lexicographically largest one. If there is no such subsequence, return an empty string.
 */
public class LongestSubsequenceRepeatedKTimes {
    //Constraints:
    //
    //n == s.length
    //2 <= n, k <= 2000
    //2 <= n < k * 8   ->  n/k<8
    //s consists of lowercase English letters.

    // n/k
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                list.add((char) (i + 'a'));
            }
        }
        if (list.isEmpty()) {
            return "";
        }
        Queue<String> q = new LinkedList<>();
        for (char c : list) {
            q.offer(String.valueOf(c));
        }
        int n = s.length();
        //2 <= n < k * 8   ->  n/k<8
        int maxLen = Math.min(n / k, 7);
        String answer = "";
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.length() > answer.length()) {
                answer = curr;
            }
            if (curr.length() == maxLen) {
                return answer;
            }
            for (char c : list) {
                String next = curr + c;
                if (isKRepeated(s, next, k)) {
                    q.offer(next);
                }
            }
        }
        return answer;
    }

    private boolean isKRepeated(String s, String target, int k) {
        int count = 0;
        int len = target.length();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == target.charAt(index)) {
                index++;
                if (index == len) {
                    count++;
                    index = 0;
                    if (count == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LongestSubsequenceRepeatedKTimes l = new LongestSubsequenceRepeatedKTimes();
        //letsleetcode
        //letleete
        //t l e
        assert l.longestSubsequenceRepeatedK("letsleetcode", 2).equals("let");
        assert l.longestSubsequenceRepeatedK("bb", 2).equals("b");
        assert l.longestSubsequenceRepeatedK("ab", 2).equals("");
        assert l.longestSubsequenceRepeatedK("letsleetcode", 2).equals("let");
    }
}
