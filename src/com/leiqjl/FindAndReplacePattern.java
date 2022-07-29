package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. Find and Replace Pattern - Medium
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean match(String word, String pattern) {
        Map<Integer, Integer> wordMap = new HashMap<>();
        Map<Integer, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            int wInt = word.charAt(i) - 'a';
            int pInt = pattern.charAt(i) - 'a';
            if (!wordMap.containsKey(wInt)) {
                wordMap.put(wInt, pInt);
            }
            if (!patternMap.containsKey(pInt)) {
                patternMap.put(pInt, wInt);
            }
            if (wordMap.get(wInt) != pInt || patternMap.get(pInt) != wInt) {
                return false;
            }
        }
        return true;
    }
}
