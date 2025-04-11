package com.leiqjl;

/**
 * 2843. Count Symmetric Integers - Easy
 */
public class CountSymmetricIntegers {
    //Constraints:
    //
    //1 <= low <= high <= 10^4
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            if (num < 100 && num % 11 == 0) {
                count++;
            } else if (num > 1000 && num < 10000) {
                int leftSum = num / 1000 + (num % 1000) / 100;
                int rightSum = (num % 100) / 10 + num % 10;
                if (leftSum == rightSum) {
                    count++;
                }
            }
        }
        return count;
    }
}
