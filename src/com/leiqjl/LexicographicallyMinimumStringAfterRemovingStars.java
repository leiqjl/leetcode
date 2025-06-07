package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 3170. Lexicographically Minimum String After Removing Stars - Medium
 */
public class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        Deque<Integer>[] freqArr = new Deque[26];
        for (int i = 0; i < 26; i++) {
            freqArr[i] = new ArrayDeque<>();
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '*') {
                freqArr[charArray[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!freqArr[j].isEmpty()) {
                        charArray[freqArr[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c != '*') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
