package com.leiqjl;

/**
 * 1716. Calculate Money in Leetcode Bank - Easy
 */
public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int a = n / 7;
        int b = n % 7;
        int result = 0;
        for (int i = 1 + a; i <= b + a; i++) {
            result = result + i;
        }
        if (a > 0) {
            result = result + a * (28 + (28 + (a - 1) * 7)) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank c = new CalculateMoneyInLeetcodeBank();
        assert c.totalMoney(4) == 10;
        assert c.totalMoney(10) == 37;
        assert c.totalMoney(20) == 96;
        assert c.totalMoney(26) == 135;
    }
}
