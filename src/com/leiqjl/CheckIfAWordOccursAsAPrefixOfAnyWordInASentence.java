package com.leiqjl;

/**
 * 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence - Easy
 *
 */
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int count = 1, idx = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (idx != -1 && sentence.charAt(i) == sentence.charAt(idx)) {
                idx++;
            } else if (sentence.charAt(i) == ' ') {
                idx = 0;
                count++;
            } else {
                idx = -1;
            }
            if (idx == searchWord.length()) {
                return count;
            }
        }
        return -1;
    }
}
