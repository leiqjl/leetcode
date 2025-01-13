package com.leiqjl;

import java.util.HashSet;

/**
 * 1805. Number of Different Integers in a String - Easy
 * You are given a string word that consists of digits and lowercase English letters.
 * <p>
 * You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".
 * <p>
 * Return the number of different integers after performing the replacement operations on word.
 * <p>
 * Two integers are considered different if their decimal representations without any leading zeros are different.
 */
public class NumberOfDifferentIntegersInAString {
    public int numDifferentIntegers(String word) {
        int n = word.length();
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(word.charAt(i))) {
                int j = i;
                while (j < n && word.charAt(j) == '0') {
                    j++;
                }
                i = j;
                while (j < n && Character.isDigit(word.charAt(j))) {
                    j++;
                }
                hashSet.add(word.substring(i, j));
                i = j - 1;
            }

        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        NumberOfDifferentIntegersInAString n = new NumberOfDifferentIntegersInAString();
        assert n.numDifferentIntegers("a123bc34d8ef34") == 3;
        assert n.numDifferentIntegers("leet1234code234") == 2;
        assert n.numDifferentIntegers("a1b01c001") == 1;
        assert n.numDifferentIntegers("035985750011523523129774573439111590559325a1554234973") == 2;
    }
}
