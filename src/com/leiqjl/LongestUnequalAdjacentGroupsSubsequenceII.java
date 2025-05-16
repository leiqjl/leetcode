package com.leiqjl;

import java.util.LinkedList;
import java.util.List;

/**
 * 2901. Longest Unequal Adjacent Groups Subsequence II - Medium
 */
public class LongestUnequalAdjacentGroupsSubsequenceII {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 > dp[i] && groups[i] != groups[j] && check(words[i], words[j])) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }
        List<String> result = new LinkedList<>();
        for (int i = maxIdx; i >= 0; i = prev[i]) {
            result.addFirst(words[i]);
        }

        return result;
    }

    private boolean check(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
