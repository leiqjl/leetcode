package com.leiqjl;

/**
 * 2423. Remove Letter To Equalize Frequency - Easy
 * You are given a 0-indexed string word, consisting of lowercase English letters.
 * You need to select one index and remove the letter at that index from word so that the frequency of every letter present in word is equal.
 * <p>
 * Return true if it is possible to remove one letter so that the frequency of all letters in word are equal, and false otherwise.
 * <p>
 * Note:
 * - The frequency of a letter x is the number of times it occurs in the string.
 * - You must remove exactly one letter and cannot chose to do nothing.
 */
public class RemoveLetterToEqualizeFrequency {
    //Constraints:
    //
    //- 2 <= word.length <= 100
    //- word consists of lowercase English letters only.
    public boolean equalFrequency(String word) {
        int[] map = new int[26];
        int n = word.length();
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }
        int max = -1;
        int[] arr = new int[n + 1];
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                arr[map[i]]++;
                max = Math.max(max, map[i]);
            }
        }
        if (max == n || max == 1) {
            return true;
        }
        if (arr[max] == 1 && (arr[max - 1] * (max - 1) == n - max)) {
            return true;
        }
        if (arr[1] == 1 && arr[max] * max == n - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RemoveLetterToEqualizeFrequency r = new RemoveLetterToEqualizeFrequency();
        assert r.equalFrequency("abcc");
        assert !r.equalFrequency("aazz");
        assert r.equalFrequency("bac");
        assert r.equalFrequency("abbcc");

    }
}
