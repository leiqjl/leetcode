package com.leiqjl;

/**
 * 208. Implement Trie (Prefix Tree) - Medium
 */
public class ImplementTrie_PrefixTree {
    class Trie {

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

        public TrieNode getNode(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (node == null) {
                    return null;
                }
                char c = prefix.charAt(i);
                node = node.children[c - 'a'];
            }
            return node;
        }

        public boolean search(String word) {
            TrieNode node = getNode(word);
            return node != null && node.flag;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = getNode(prefix);
            return node != null;
        }
    }

    class TrieNode {
        boolean flag;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
        }
    }


}
