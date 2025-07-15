package com.leiqjl;

/**
 * 3136. Valid Word - Easy
 * A word is considered valid if:
 * <p>
 * It contains a minimum of 3 characters.
 * It contains only digits (0-9), and English letters (uppercase and lowercase).
 * It includes at least one vowel.
 * It includes at least one consonant.
 * You are given a string word.
 * <p>
 * Return true if word is valid, otherwise, return false.
 */
public class ValidWord {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean containVowel = false, containConsonant = false;
        for (char c : word.toCharArray()) {
            c = Character.toLowerCase(c);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if ("aeiou".indexOf(c) >= 0) {
                    containVowel = true;
                } else {
                    containConsonant = true;
                }
            } else if (!(c >= '0' && c <= '9'))
                return false;
        }
        return containVowel && containConsonant;
    }
}
