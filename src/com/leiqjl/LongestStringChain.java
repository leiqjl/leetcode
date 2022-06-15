package com.leiqjl;

import java.util.*;

/**
 * 1048. Longest String Chain - Medium
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        HashMap<String, Integer> mem = new HashMap<>();
        int max = 0;
        for (String w : words) {
            max = Math.max(max, dfs(wordSet, mem, w));
        }
        return max;
    }

    private int dfs(Set<String> wordSet, HashMap<String, Integer> mem, String current) {
        if (mem.containsKey(current)) {
            return mem.get(current);
        }
        int max = 1;
        StringBuilder sb = new StringBuilder(current);
        for (int i = 0; i < current.length(); i++) {
            sb.deleteCharAt(i);
            String prev = sb.toString();
            if (wordSet.contains(prev)) {
                max = Math.max(max, 1 + dfs(wordSet, mem, prev));
            }
            sb.insert(i, current.charAt(i));
        }
        mem.put(current, max);
        return max;
    }

    public int longestStrChain1(String[] words) {
        int max = 0;
        Arrays.sort(words, Comparator.comparing(String::length));
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            int count = 0;
            for (int i = 0; i < sb.length(); i++) {
                sb.deleteCharAt(i);
                count = Math.max(count, hashMap.getOrDefault(sb.toString(), 0) + 1);
                sb.insert(i, word.charAt(i));
            }
            hashMap.put(word, count);
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestStringChain l = new LongestStringChain();
        //Input: words = ["a","b","ba","bca","bda","bdca"]
        //Output: 4
        //Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        assert l.longestStrChain(words) == 4;
        //Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
        //Output: 5
        //Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
        String[] words1 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        assert l.longestStrChain(words1) == 5;
        //Input: words = ["abcd","dbqca"]
        //Output: 1
        //Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
        //["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
        String[] words2 = {"abcd", "dbqca"};
        assert l.longestStrChain(words2) == 1;
    }
}
