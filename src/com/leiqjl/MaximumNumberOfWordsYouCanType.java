package com.leiqjl;

/**
 * 1935. Maximum Number of Words You Can Type - Easy
 */
public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }
        String[] words = text.split(" ");
        int count = words.length;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (broken[c - 'a']) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}
