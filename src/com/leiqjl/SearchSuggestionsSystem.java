package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1268. Search Suggestions System - Medium
 */
public class SearchSuggestionsSystem {
    class Trie {
        TrieNode root;
        List<String> suggestedProducts;

        class TrieNode {
            TrieNode[] children;
            boolean isWord;

            TrieNode() {
                children = new TrieNode[26];
                isWord = false;
            }

        }

        Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public List<String> getSuggestedProducts(String prefix) {
            TrieNode cur = root;
            suggestedProducts = new ArrayList<>();
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return suggestedProducts;
                }
                cur = cur.children[c - 'a'];
            }
            dfs(cur, prefix);
            return suggestedProducts;
        }

        private void dfs(TrieNode node, String prefix) {
            if (suggestedProducts.size() == 3) {
                return;
            }
            if (node.isWord) {
                suggestedProducts.add(prefix);
            }
            for (char c = 'a'; c <= 'z'; c++) {
                if (node.children[c - 'a'] == null) {
                    continue;
                }
                dfs(node.children[c - 'a'], prefix + c);
            }
        }
    }

    //Trie
    public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            result.add(trie.getSuggestedProducts(searchWord.substring(0, i)));
        }
        return result;
    }

    // binary search
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        String prefix = "";
        int begin = 0, lastBegin = 0;
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            begin = getLowBounds(products, lastBegin, prefix);

            List<String> list = new ArrayList<>(3);
            for (int i = begin; i < Math.min(begin + 3, products.length); i++) {
                if (products[i].length() >= prefix.length() && products[i].startsWith(prefix)) {
                    list.add(products[i]);
                }
            }
            result.add(list);
            lastBegin = begin;
        }
        return result;
    }

    private int getLowBounds(String[] products, int begin, String prefix) {
        int end = products.length;
        int mid;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (products[mid].compareTo(prefix) >= 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem s = new SearchSuggestionsSystem();
        //Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
        //Output: [
        //["mobile","moneypot","monitor"],
        //["mobile","moneypot","monitor"],
        //["mouse","mousepad"],
        //["mouse","mousepad"],
        //["mouse","mousepad"]
        //]
        //Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
        //After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
        //After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> lists = s.suggestedProducts(products, searchWord);
        System.out.println(lists);

        //Input: products = ["havana"], searchWord = "havana"
        //Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
        products = new String[]{"havana"};
        searchWord = "havana";
        lists = s.suggestedProducts(products, searchWord);
        System.out.println(lists);
        //Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
        //Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
        products = new String[]{"bags", "baggage", "banner", "box", "cloths"};
        searchWord = "bags";
        lists = s.suggestedProducts(products, searchWord);
        System.out.println(lists);
    }
}
