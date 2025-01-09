package com.leiqjl;

/**
 * 3042. Count Prefix and Suffix Pairs I - Easy
 */
public class CountPrefixAndSuffixPairsI {

    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) {
                    continue;
                }
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    result++;
                }
            }
        }
        return result;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {

        }
    }

    private boolean isStartWith(TrieNode root, String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    public void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
    }

    public int countPrefixSuffixPairs1(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            TrieNode prefixRoot = new TrieNode();
            insert(prefixRoot, words[i]);
            TrieNode suffixRoot = new TrieNode();
            insert(suffixRoot, new StringBuilder(words[i]).reverse().toString());
            for (int j = 0; j < i; j++) {
                if (isStartWith(prefixRoot, words[j]) && isStartWith(suffixRoot, new StringBuilder(words[j]).reverse().toString())) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountPrefixAndSuffixPairsI c = new CountPrefixAndSuffixPairsI();
        assert c.countPrefixSuffixPairs(new String[]{"a", "aba", "ababa", "aa"}) == 4;
        assert c.countPrefixSuffixPairs(new String[]{"pa", "papa", "ma", "mama"}) == 2;
        assert c.countPrefixSuffixPairs(new String[]{"abab", "ab"}) == 0;
        assert c.countPrefixSuffixPairs(new String[]{"a", "c", "cacaa", "ccccc"}) == 1;
        assert c.countPrefixSuffixPairs(new String[]{"bc", "cbabb", "aabb", "bcaa", "caabc"}) == 0;
    }
}
