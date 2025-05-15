package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2900. Longest Unequal Adjacent Groups Subsequence I - Easy
 */
public class LongestUnequalAdjacentGroupsSubsequenceI {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }
        return result;
    }
}
