package com.leiqjl;

import java.util.*;

/**
 * 187. Repeated DNA Sequences - Medium
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 * <p>
 * ·For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 * <p>
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * You may return the answer in any order.
 */
public class RepeatedDNASequences {
    //Constraints:
    //
    //1 <= s.length <= 10^5
    //s[i] is either 'A', 'C', 'G', or 'T'.
    //rolling hash
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 0);
        hashMap.put('C', 1);
        hashMap.put('G', 2);
        hashMap.put('T', 3);
        int seed = 5;
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> hashSet = new HashSet<>();
        int h = 0;
        int power = (int) Math.pow(seed, 9);
        for (int i = 0; i < s.length(); i++) {
            if (i > 9) {
                h = h - hashMap.get(s.charAt(i - 10)) * power;
            }
            h = h * seed + hashMap.get(s.charAt(i));
            if (i > 8) {
                if (seen.contains(h)) {
                    hashSet.add(s.substring(i - 9, i + 1));
                } else {
                    seen.add(h);
                }
            }
        }
        return new ArrayList<>(hashSet);
    }



    public static void main(String[] args) {

        RepeatedDNASequences r = new RepeatedDNASequences();
        System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(r.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        assert r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").equals(List.of("AAAAACCCCC", "CCCCCAAAAA"));
        assert r.findRepeatedDnaSequences("AAAAAAAAAAAAA").equals(List.of("AAAAAAAAAA"));
    }
}
