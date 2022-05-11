package com.leiqjl;

/**
 * 1641. Count Sorted Vowel Strings - Medium
 * <p>
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * <p>
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 */
public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        // a -> a+e+i+o+u(aa,ae,ai,ao,au)
        // e -> e+i+o+u(ee,ei,eo,eu)
        // i -> i+o+u(ii,io,iu)
        // o -> o+u(oo,ou)
        // u -> u(uu)
        while (n > 1) {
            o += u;
            i += o;
            e += i;
            a += e;
            n--;
        }
        return a + e + i + o + u;
    }


    public static void main(String[] args) {
        CountSortedVowelStrings c = new CountSortedVowelStrings();
        //Input: n = 1
        //Output: 5
        //["a","e","i","o","u"].
        assert c.countVowelStrings(1) == 5;
        //Input: n = 2
        //Output: 15
        //["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
        assert c.countVowelStrings(2) == 15;
        //Input: n = 33
        //Output: 66045
        assert c.countVowelStrings(33) == 66045;
    }
}
