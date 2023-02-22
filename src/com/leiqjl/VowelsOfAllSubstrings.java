package com.leiqjl;

/**
 * 2063. Vowels of All Substrings - Medium
 * Given a string word, return the sum of the number of vowels ('a', 'e', 'i', 'o', and 'u') in every substring of word.
 * <p>
 * A substring is a contiguous (non-empty) sequence of characters within a string.
 * <p>
 * Note: Due to the large constraints, the answer may not fit in a signed 32-bit integer. Please be careful during the calculations.
 */
public class VowelsOfAllSubstrings {
    public long countVowels(String word) {
        int n = word.length();
        //abiba
        //(i+1)*(n-i)
        //i=2, begin a b i
        //     end       i b a
        long count = 0;
        for (int i = 0; i < n; i++) {
            if ("aeiou".indexOf(word.charAt(i)) > 0) {
                count += (long) (i + 1) * (n - i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        VowelsOfAllSubstrings v = new VowelsOfAllSubstrings();
        //Input: word = "aba"
        //Output: 6
        //Explanation:
        //All possible substrings are: "a", "ab", "aba", "b", "ba", and "a".
        //- "b" has 0 vowels in it
        //- "a", "ab", "ba", and "a" have 1 vowel each
        //- "aba" has 2 vowels in it
        //Hence, the total sum of vowels = 0 + 1 + 1 + 1 + 1 + 2 = 6.
        assert v.countVowels("aba") == 6;
        //Input: word = "abc"
        //Output: 3
        //Explanation:
        //All possible substrings are: "a", "ab", "abc", "b", "bc", and "c".
        //- "a", "ab", and "abc" have 1 vowel each
        //- "b", "bc", and "c" have 0 vowels each
        //Hence, the total sum of vowels = 1 + 1 + 1 + 0 + 0 + 0 = 3.
        assert v.countVowels("abc") == 3;
        //Input: word = "ltcd"
        //Output: 0
        //Explanation: There are no vowels in any substring of "ltcd".
        assert v.countVowels("ltcd") == 0;
        assert v.countVowels("noosabasboosa") == 237;
    }
}
