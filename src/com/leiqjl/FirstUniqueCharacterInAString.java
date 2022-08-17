package com.leiqjl;

/**
 * 387. First Unique Character in a String - Easy
 */
public class FirstUniqueCharacterInAString {
    //1 <= s.length <= 105
    //s consists of only lowercase English letters.
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
