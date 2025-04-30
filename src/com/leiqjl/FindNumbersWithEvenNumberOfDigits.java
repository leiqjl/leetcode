package com.leiqjl;

/**
 * 1295. Find Numbers with Even Number of Digits - Easy
 */
public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        boolean isEven = false;
        for (int num : nums) {
            if (isEven(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean isEven(int num) {
        boolean isEven = true;
        while (num > 0) {
            num = num / 10;
            isEven = !isEven;
        }
        return isEven;
    }
}
