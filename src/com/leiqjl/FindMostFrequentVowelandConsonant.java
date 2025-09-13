package com.leiqjl;

/**
 * 3541. Find Most Frequent Vowel and Consonant - Easy
 */
public class FindMostFrequentVowelandConsonant {
    public int maxFreqSum(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                maxVowelFreq = Math.max(maxVowelFreq, cnt[i]);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, cnt[i]);
            }
        }
        return maxVowelFreq + maxConsonantFreq;
    }
}
