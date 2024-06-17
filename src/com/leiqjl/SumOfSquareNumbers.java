package com.leiqjl;

/**
 * 633. Sum of Square Numbers - Medium
 */
public class SumOfSquareNumbers {
    //0 <= c <= 2^31 - 1
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            long b = c - a * a;
            if (binarySearch(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(long l, long r, long target) {
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == target) {
                return true;
            } else if (mid * mid < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        assert s.judgeSquareSum(5);
        assert !s.judgeSquareSum(3);
        assert s.judgeSquareSum(2);
    }
}
