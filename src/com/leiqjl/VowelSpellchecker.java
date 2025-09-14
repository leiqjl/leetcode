package com.leiqjl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 966. Vowel Spellchecker - Medium
 */
public class VowelSpellchecker {
    //When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
    //When the query matches a word up to capitlization, you should return the first such match in the wordlist.
    //When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
    //If the query has no matches in the wordlist, you should return the empty string.
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] result = new String[n];
        Set<String> set = new HashSet<>();
        Map<String, String> capMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        for (String word : wordlist) {
            set.add(word);
            String cap = word.toLowerCase();
            capMap.putIfAbsent(cap, word);
            String vowel = cap.replaceAll("[aeiou]", "#");
            vowelMap.putIfAbsent(vowel, word);
        }
        for (int i = 0; i < n; i++) {
            String query = queries[i];
            if (set.contains(query)) {
                result[i] = query;
                continue;
            }
            String cap = query.toLowerCase();
            if (capMap.containsKey(cap)) {
                result[i] = capMap.get(cap);
                continue;
            }
            String vowel = cap.replaceAll("[aeiou]", "#");
            if (vowelMap.containsKey(vowel)) {
                result[i] = vowelMap.get(vowel);
                continue;
            }
            result[i] = "";
        }
        return result;
    }
}
