package com.leiqjl;

/**
 * 258. Add Digits - Easy
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        AddDigits a = new AddDigits();
        assert a.addDigits(38) == 2;
        assert a.addDigits(0) == 0;
    }
}
