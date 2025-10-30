package com.leiqjl;

/**
 * 440. K-th Smallest in Lexicographical Order - Hard
 */
public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = countSteps(n, cur, cur + 1);
            if (k >= steps) {
                k -= steps;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += (int) (Math.min(n + 1, prefix2) - prefix1);
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        KthSmallestInLexicographicalOrder k = new KthSmallestInLexicographicalOrder();
        assert k.findKthNumber(13, 2) == 10;
        assert k.findKthNumber(1, 1) == 1;
    }
}
