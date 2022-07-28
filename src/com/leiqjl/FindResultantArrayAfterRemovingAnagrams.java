package com.leiqjl;

import java.util.LinkedList;
import java.util.List;

/**
 * 2273. Find Resultant Array After Removing Anagrams - Medium
 */
public class FindResultantArrayAfterRemovingAnagrams {

    public List<String> removeAnagrams(String[] words) {
        LinkedList<String> deque = new LinkedList<>();
        for (int i = words.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && isAnagram(deque.getFirst(), words[i])) {
                deque.removeFirst();
            }
            deque.addFirst(words[i]);
        }
        return deque;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[t.charAt(i) - 'a']--;
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i : cnt) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
