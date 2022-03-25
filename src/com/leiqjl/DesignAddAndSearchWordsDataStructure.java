package com.leiqjl;

/**
 * 211. Design Add and Search Words Data Structure - Medium
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * - WordDictionary() Initializes the object.
 * - void addWord(word) Adds word to the data structure, it can be matched later.
 * - bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */
public class DesignAddAndSearchWordsDataStructure {
    class WordDictionary {
        private int size = 0;

        class TrieNode {
            boolean flag;
            TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;

        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
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

        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(TrieNode node, String word, int i) {
            if (node == null) {
                return false;
            }
            if (i == word.length()) {
                return node.flag;
            }
            char c = word.charAt(i);
            if (c != '.') {
                return search(node.children[c - 'a'], word, i + 1);
            }
            for (int j = 0; j < 26; j++) {
                if (search(node.children[j], word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

