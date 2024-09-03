package com.leiqjl;

/**
 * 1945. Sum of Digits of String After Convert - Easy
 */
public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a' + 1;
            sum = sum + i % 10 + i / 10;
        }
        for (int i = 1; i < k; i++) {
            int temp = 0;
            while (sum > 0) {
                temp += sum % 10;
                sum /= 10;
            }
            sum = temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfDigitsOfStringAfterConvert s = new SumOfDigitsOfStringAfterConvert();
        assert s.getLucky("iiii", 1) == 36;
        assert s.getLucky("leetcode", 2) == 6;
        assert s.getLucky("zbax", 2) == 8;
    }
}
