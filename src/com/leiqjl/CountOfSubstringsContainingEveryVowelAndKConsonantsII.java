package com.leiqjl;

import java.util.HashMap;

/**
 * 3306. Count of Substrings Containing Every Vowel and K Consonants II - Medium
 * You are given a string word and a non-negative integer k.
 * <p>
 * Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
 */
public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    public long countOfSubstrings(String word, int k) {
        return countSubstringsLeastKConsonants(word, k) - countSubstringsLeastKConsonants(word, k + 1);
    }

    private long countSubstringsLeastKConsonants(String word, int k) {
        long res = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int count = 0;
        while (right < word.length()) {
            char c = word.charAt(right);
            if (isVowel(c)) {
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            } else {
                count++;
            }
            while (count >= k && hashMap.size() == 5) {
                res += (word.length() - right);
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                    if (hashMap.get(leftChar) == 0) {
                        hashMap.remove(leftChar);
                    }
                } else {
                    count--;
                }
                left++;
            }
            right++;
        }
        return res;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        CountOfSubstringsContainingEveryVowelAndKConsonantsII c = new CountOfSubstringsContainingEveryVowelAndKConsonantsII();
        assert c.countOfSubstrings("aeioqq", 1) == 0;
        assert c.countOfSubstrings("aeiou", 0) == 1;
        assert c.countOfSubstrings("ieaouqqieaouqq", 1) == 3;
    }
}
