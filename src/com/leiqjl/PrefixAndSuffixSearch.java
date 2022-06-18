package com.leiqjl;

/**
 * 745. Prefix and Suffix Search - Hard
 */
public class PrefixAndSuffixSearch {
    class TrieNode {
        int weight = 0;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[27];
        }
    }

    class WordFilter {
        TrieNode root;

        public WordFilter(String[] words) {
            root = new TrieNode();
            for (int w = 0; w < words.length; w++) {
                String word = words[w] + "{";
                for (int i = 0; i < word.length(); i++) {
                    TrieNode cur = root;
                    cur.weight = w;
                    for (int j = i; j < 2 * word.length() - 1; j++) {
                        int k = word.charAt(j % word.length()) - 'a';
                        if (cur.children[k] == null) {
                            cur.children[k] = new TrieNode();
                        }
                        cur = cur.children[k];
                        cur.weight = w;
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            TrieNode cur = root;
            for (char c : (suffix + "{" + prefix).toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return -1;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.weight;
        }
    }
}
