package com.leiqjl;

/**
 * 3201. Find the Maximum Length of Valid Subsequence I - Medium
 */
public class FindTheMaximumLengthOfValidSubsequenceI {
    public int maximumLength(int[] nums) {
        int allEven = 0, allOdd = 0, altEven = 0, altOdd = 0;
        for (int num : nums) {
            if ((num & 1) == 1) {
                altOdd = altEven + 1;
                allOdd += 1;
            } else {
                altEven = altOdd + 1;
                allEven += 1;
            }
        }
        return Math.max(Math.max(allOdd, allEven), Math.max(altEven, altOdd));
    }

    public static void main(String[] args) {
        FindTheMaximumLengthOfValidSubsequenceI f = new FindTheMaximumLengthOfValidSubsequenceI();
        assert f.maximumLength(new int[]{1, 2, 3, 4}) == 4;
        assert f.maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}) == 6;
        assert f.maximumLength(new int[]{1, 3}) == 2;
        assert f.maximumLength(new int[]{2, 3}) == 2;
    }
}
