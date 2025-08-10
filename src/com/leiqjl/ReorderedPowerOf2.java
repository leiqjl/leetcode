package com.leiqjl;

/**
 * 869. Reordered Power of 2 - Medium
 */
public class ReorderedPowerOf2 {

    //1 <= n <= 10^9
    public boolean reorderedPowerOf2(int n) {
        long base = calculate(n);
        for (int i = 0; i <= 29; i++) {
            if (calculate(1<<i) == base) {
                return true;
            }
        }
        return false;
    }

    private long calculate(int n) {
        long answer = 0;
        while (n > 0) {
            answer = (long) (answer + Math.pow(10, n%10));
            n/=10;
        }
        return answer;
    }
}
