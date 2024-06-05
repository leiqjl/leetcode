package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. Find Common Characters - Easy
 */
public class FindCommonCharacters {
    //1 <= words.length <= 100
    //1 <= words[i].length <= 100
    //words[i] consists of lowercase English letters.
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] map = new int[26];
        countChars(words[0], map);
        for (int i = 1; i < words.length; i++) {
            int[] newMap = new int[26];
            countChars(words[i], newMap);
            for (int j = 0; j < 26; j++) {
                map[j] = Math.min(map[j], newMap[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (map[i] > 0) {
                result.add(String.valueOf((char) ('a' + i)));
                map[i]--;
            }
        }
        return result;
    }

    private void countChars(String word, int[] map) {
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }
    }

    public static void main(String[] args) {
        FindCommonCharacters f = new FindCommonCharacters();
        //Input: words = ["bella","label","roller"]
        //Output: ["e","l","l"]
        assert "[e, l, l]".equals(f.commonChars(new String[]{"bella", "label", "roller"}).toString());
        //Input: words = ["cool","lock","cook"]
        //Output: ["c","o"]
        assert "[c, o]".equals(f.commonChars(new String[]{"cool", "lock", "cook"}).toString());
    }
}
