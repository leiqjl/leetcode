package com.leiqjl;

/**
 * 520. Detect Capital - Easy
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }
        if (count == 0 || count == word.length()) {
            return true;
        }
        return count == 1 && Character.isUpperCase(word.charAt(0));
    }
}
