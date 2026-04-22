package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2452. Words Within Two Edits of Dictionary  - Medium
 */
public class WordsWithinTwoEditsOfDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean flag;
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.flag = true;
    }

    private boolean search(String word, TrieNode node, int i, int count) {
        if (count > 2 || node == null) {
            return false;
        }
        if (i == word.length()) {
            return node.flag;
        }
        int next = word.charAt(i) - 'a';
        if (node.children[next] != null) {
            if (search(word, node.children[next], i + 1, count)) {
                return true;
            }
        }
        if (count < 2) {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null && j != next) {
                    if (search(word, node.children[j], i + 1, count + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        for (String dic : dictionary) {
            insert(dic);
        }
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            if (search(query, root, 0, 0)) {
                result.add(query);
            }
        }
        return result;
    }
}
