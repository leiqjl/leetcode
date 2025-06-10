package com.leiqjl;

/**
 * 3442. Maximum Difference Between Even and Odd Frequency I - Easy
 */
public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int minEvenFreq = s.length(), maxOddFreq = 0;
        for (int f : freq) {
            if (f == 0) {
                continue;
            }
            if ((f & 1) == 0) {
                minEvenFreq = Math.min(minEvenFreq, f);
            } else {
                maxOddFreq = Math.max(maxOddFreq, f);
            }
        }
        return maxOddFreq - minEvenFreq;
    }
}
