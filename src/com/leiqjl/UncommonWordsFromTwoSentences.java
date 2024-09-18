package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 884. Uncommon Words from Two Sentences - Easy
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] s1s = s1.split(" ");
        String[] s2s = s2.split(" ");
        for (String s : s1s) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        for (String s : s2s) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (String s : hashMap.keySet()) {
            if (hashMap.get(s) == 1) {
                result.add(s);
            }
        }
        return result.toArray(new String[0]);
    }
}
