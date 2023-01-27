package com.leiqjl;

import java.util.List;

/**
 * 139. Word Break - Medium
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                if (wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        w.wordBreak("leetcode", List.of("leet", "code"));
        w.wordBreak("applepenapple", List.of("apple", "pen"));
        w.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));
    }
}
