package com.leiqjl;

/**
 * 1317. Convert Integer to the Sum of Two No-Zero Integers - Easy
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        int i = 0, j = 0, base = 1;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            if ((temp == 0 || temp == 1) && n > 0) {
                i = i + (temp + 1) * base;
                j = j + 9 * base;
                n--;
            } else {
                i = i + base;
                j = j + (temp - 1) * base;
            }
            base *= 10;
        }
        return new int[]{i, j};
    }
}
