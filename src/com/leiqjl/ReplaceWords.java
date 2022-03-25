package com.leiqjl;

import java.util.List;

/**
 * 648. Replace Words - Medium
 */
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String dic : dictionary) {
            trie.insert(dic);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : sentence.split(" ")) {
            String key = trie.shortestPrefixOf(s);
            if (!key.equals("")) {
                sb.append(key).append(" ");
            } else {
                sb.append(s).append(" ");
            }

        }
        return sb.substring(0, sb.length() - 1);
    }

    class Trie {
        class TrieNode {
            boolean flag;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

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

        public String shortestPrefixOf(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node == null) {
                    return "";
                }
                if (node.flag) {
                    return word.substring(0, i);
                }
                node = node.children[word.charAt(i) - 'a'];
            }
            if (node != null && node.flag) {
                return word;
            }
            return "";
        }
    }
}
