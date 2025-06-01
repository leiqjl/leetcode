package com.leiqjl;

/**
 * 2929. Distribute Candies Among Children II - Medium
 */
public class DistributeCandiesAmongChildrenII {
    // i <= min(n,limit)
    // j <= min(n-i,limit)
    // n-i-j <= limit   -   j>=n-i-limit
    public long distributeCandies(int n, int limit) {
        long answer = 0;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            if ((n - i) > limit * 2) {
                continue;
            }
            answer = answer + (Math.min(n - i, limit) - Math.max(n - i - limit, 0) + 1);
        }
        return answer;
    }

    // no limit C(n+2,2)  n+2 pos
    // at least one over limit
    //     limit+1    3*C(n-(limit+1)+2,2)
    //at least two over limit
    //     3* C(n-2*(limit+1)+2,2)
    //all over limit
    //      C(n-3*(limit+1)+2,2)
    //∣A∪B∪C∣=∣A∣+∣B∣+∣C∣−∣A∩B∣−∣A∩C∣−∣B∩C∣+∣A∩B∩C∣
    public long distributeCandies1(int n, int limit) {
        return comb(n + 2) - 3 * comb(n - (limit + 1) + 2) + 3 * comb(n - 2 * (limit + 1) + 2) - comb(n - 3 * (limit + 1) + 2);
    }

    private long comb(int i) {
        if (i < 0) {
            return 0;
        }
        return (long) i * (i - 1) / 2;
    }
}
