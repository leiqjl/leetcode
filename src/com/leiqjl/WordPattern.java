package com.leiqjl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 290. Word Pattern - Easy
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Object, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(hashMap.put(pattern.charAt(i), i), hashMap.put(words[i], i))) {
                return false;
            }
        }
        return true;
    }
}
