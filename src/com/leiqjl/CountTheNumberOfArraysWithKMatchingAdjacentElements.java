package com.leiqjl;

/**
 * 3405. Count the Number of Arrays with K Matching Adjacent Elements - Hard
 */
public class CountTheNumberOfArraysWithKMatchingAdjacentElements {
    //1 <= n <= 10^5
    //1 <= m <= 10^5
    //0 <= k <= n - 1


    static final int mod = 1000000007;
    static final int MAX = 100000;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    static {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
        invFact[MAX - 1] = quickPow(fact[MAX - 1], mod - 2);
        for (int i = MAX - 1; i > 0; i--) {
            invFact[i-1] = invFact[i] * (i) % mod;
        }
    }

    //n-1对 k对相同元素 n-1-k对不同元素
    //n-k段  m * (m-1)^(n-k-1) * C(n-1,n-k-1)
    //C(n-1,n-k-1)=C(n-1,k)
    //m * (m-1)^(n-k-1) * C(n-1,k)
    public int countGoodArrays(int n, int m, int k) {

        return (int) ((m * quickPow(m - 1, n - k - 1) % mod) * comb(n - 1, k) % mod);
    }

    private long comb(int n, int k) {
        return (fact[n] * invFact[k] % mod) * invFact[n - k] % mod;
    }

    private static long quickPow(long base, int n) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * base % mod;
            }
            base = base * base % mod;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountTheNumberOfArraysWithKMatchingAdjacentElements c = new CountTheNumberOfArraysWithKMatchingAdjacentElements();
        //[1, 1, 2], [1, 2, 2]
        // [2, 2, 1],[2, 1, 1]
        assert c.countGoodArrays(3, 2, 1) == 4;
        assert c.countGoodArrays(4, 2, 2) == 6;
        assert c.countGoodArrays(5, 2, 0) == 2;
        assert c.countGoodArrays(5581, 58624, 4766) == 846088010;
    }
}
