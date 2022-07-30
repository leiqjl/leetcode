package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 916. Word Subsets - Medium
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] map = new int[26];
        List<String> result = new ArrayList<>();
        for (String s : words2) {
            int[] sMap = count(s);
            for (int i = 0; i < 26; ++i) {
                map[i] = Math.max(map[i], sMap[i]);
            }
        }

        int i;
        for (String s : words1) {
            int[] sMap = count(s);
            for (i = 0; i < 26; i++) {
                if (sMap[i] < map[i]) {
                    break;
                }
            }
            if (i == 26) {
                result.add(s);
            }
        }
        return result;
    }

    private int[] count(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }

    public static void main(String[] args) {
        WordSubsets w = new WordSubsets();
        //Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
        //Output: ["facebook","google","leetcode"]
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        System.out.println(w.wordSubsets(words1, new String[]{"e", "o"}));
        //Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
        //Output: ["apple","google","leetcode"]
        System.out.println(w.wordSubsets(words1, new String[]{"l", "e"}));
    }
}
