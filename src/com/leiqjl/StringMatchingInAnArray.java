package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. String Matching in an Array - Easy
 */
public class StringMatchingInAnArray {
    class TrieNode {
        int freq = 0;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {

        }
    }

    private boolean isSubstring(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.children[c - 'a'];
        }
        return node.freq > 1;
    }

    public void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.freq++;
        }
    }

    public List<String> stringMatching(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                insert(root, word.substring(i));
            }
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isSubstring(root, word)) {
                list.add(word);
            }
        }
        return list;
    }


    //KMP
    public List<String> stringMatching1(String[] words) {
        int n = words.length;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] next = generateNext(words[i]);
            for (int j = 0; j < n; j++) {
                if (i != j && kmp(words[j], words[i], next)) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }

    private int[] generateNext(String pattern) {
        int[] next = new int[pattern.length()];
        int len = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (len > 0 && pattern.charAt(i) != pattern.charAt(len)) {
                len = next[len - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
            }
            next[i] = len;
        }
        return next;
    }

    private boolean kmp(String s, String pattern, int[] next) {
        int i = 0, j = 0;
        while (i < s.length() && j < pattern.length()) {
            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }

            }
        }
        return j == pattern.length();
    }

    public static void main(String[] args) {
        StringMatchingInAnArray s = new StringMatchingInAnArray();
        assert s.stringMatching(new String[]{"mass", "as", "hero", "superhero"})
                .equals(List.of("as", "hero"));
        assert s.stringMatching(new String[]{"leetcode", "et", "code"})
                .equals(List.of("et", "code"));
    }

}
