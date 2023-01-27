package com.leiqjl;

import java.util.*;

/**
 * 472. Concatenated Words - Hard
 */
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        HashSet<String> hashSet = new HashSet<>();
        for (String word : words) {
            if (isConcatenatedWord(word, hashSet)) {
                result.add(word);
            }
            hashSet.add(word);
        }
        return result;
    }

    private boolean isConcatenatedWord(String word, HashSet<String> hashSet) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                if (hashSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
