package com.leiqjl;

import java.util.HashSet;

/**
 * 804. Unique Morse Code Words - Easy
 */
public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] keywords = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> hashSet = new HashSet<>();
        for (String word : words) {
            StringBuilder key = new StringBuilder();
            for (char c : word.toCharArray()) {
                key.append(keywords[c - 'a']);
            }
            hashSet.add(key.toString());
        }
        return hashSet.size();
    }
}
