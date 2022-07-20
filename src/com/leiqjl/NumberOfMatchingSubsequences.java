package com.leiqjl;

import java.text.StringCharacterIterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 792. Number of Matching Subsequences - Medium
 */
public class NumberOfMatchingSubsequences {
    //1 <= s.length <= 5 * 104
    //1 <= words.length <= 5000
    //1 <= words[i].length <= 50
    //s and words[i] consist of only lowercase English letters.
    public int numMatchingSubseq(String s, String[] words) {
        List<StringCharacterIterator>[] map = new List[26];
        for (int i = 0; i < 26; i++) {
            map[i] = new LinkedList<>();
        }
        for (String w : words) {
            char c = w.charAt(0);
            map[c - 'a'].add(new StringCharacterIterator(w));
        }

        int count = 0;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            List<StringCharacterIterator> list = map[idx];
            if (list.isEmpty()) {
                continue;
            }
            map[idx] = new LinkedList<>();
            for (StringCharacterIterator it : list) {
                if (it.next() == it.DONE) {
                    count++;
                } else {
                    map[it.current() - 'a'].add(it);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubsequences n = new NumberOfMatchingSubsequences();
        //Input: s = "abcde", words = ["a","bb","acd","ace"]
        //Output: 3
        //Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
        assert n.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}) == 3;
        //Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
        //Output: 2
        assert n.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}) == 2;
    }
}
