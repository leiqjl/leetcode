package com.leiqjl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 820. Short Encoding of Words - Medium
 */
public class ShortEncodingOfWords {

    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String w : words) {
            set.add(w);
        }

        for (String w : words) {
            for (int i = 1; i < w.length(); i++) {
                set.remove(w.substring(i));
            }
        }
        int result = 0;
        for (String w : set) {
            result = result + w.length() + 1;
        }
        return result;
    }

    //Trie
    public int minimumLengthEncoding1(String[] words) {
        TrieNode root = new TrieNode();
        HashMap<TrieNode, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                cur = cur.get(words[i].charAt(j));
            }
            map.put(cur, i);
        }
        int result = 0;
        for (Map.Entry<TrieNode, Integer> entry : map.entrySet()) {
            TrieNode key = entry.getKey();
            Integer value = entry.getValue();
            if (key.isLeaf) {
                result = result + words[value].length() + 1;
            }
        }
        return result;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isLeaf;

        TrieNode() {
            children = new TrieNode[26];
            isLeaf = true;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                isLeaf = false;
            }
            return children[c - 'a'];
        }
    }
}
