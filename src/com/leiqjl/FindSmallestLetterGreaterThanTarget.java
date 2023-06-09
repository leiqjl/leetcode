package com.leiqjl;

/**
 * 744. Find Smallest Letter Greater Than Target - Easy
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {

        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l == letters.length ? letters[0] : letters[l];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget f = new FindSmallestLetterGreaterThanTarget();
        assert f.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a') == 'c';
        assert f.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c') == 'f';
        assert f.nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z') == 'x';
    }
}
