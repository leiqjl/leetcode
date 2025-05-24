package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2942. Find Words Containing Character - Easy
 */
public class FindWordsContainingCharacter {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (c == x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}
