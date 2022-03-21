package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels - Medium
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * <p>
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * <p>
 * Return a list of integers representing the size of these parts.
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] idx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            idx[s.charAt(i) - 'a'] = i;
        }
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(idx[s.charAt(i) - 'a'], end);
            if (end == i) {
                result.add(end - begin + 1);
                begin = end + 1;
            }
        }
        return result;
    }
}
