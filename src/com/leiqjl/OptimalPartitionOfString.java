package com.leiqjl;

import java.util.Arrays;

/**
 * 2405. Optimal Partition of String - Medium
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
 * That is, no letter appears in a single substring more than once.
 *
 * Return the minimum number of substrings in such a partition.
 *
 * Note that each character should belong to exactly one substring in a partition.
 */
public class OptimalPartitionOfString {
    public int partitionString(String s) {
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);
        int idx = 0, count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (lastIdx[s.charAt(i) - 'a'] >= idx) {
                count++;
                idx = i;
            }
            lastIdx[s.charAt(i) - 'a'] = idx;
        }
        return count;
    }

    public static void main(String[] args) {
        OptimalPartitionOfString o = new OptimalPartitionOfString();
        assert o.partitionString("abacaba") == 4;
        assert o.partitionString("ssssss") == 6;
    }
}
