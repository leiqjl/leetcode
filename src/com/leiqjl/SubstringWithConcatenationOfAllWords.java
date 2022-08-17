package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words - Hard
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> tempMap = new HashMap<>();
        int len = words[0].length(), n = words.length;
        for (int i = 0; i < s.length() - n * len + 1; i++) {
            tempMap.clear();
            int j = 0;
            while (j < n) {
                String str = s.substring(i + j * len, i + (j + 1) * len);
                if (countMap.containsKey(str)) {
                    int count = tempMap.getOrDefault(str, 0) + 1;
                    if (count > countMap.get(str)) {
                        break;
                    }
                    tempMap.put(str, count);
                } else {
                    break;
                }
                j++;
            }
            if (j == n) {
                result.add(i);
            }
        }
        return result;
    }
}
