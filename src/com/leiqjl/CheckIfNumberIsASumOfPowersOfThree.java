package com.leiqjl;

/**
 * 1780. Check if Number is a Sum of Powers of Three - Medium
 *
 * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
 *
 * An integer y is a power of three if there exists an integer x such that y == 3^x.
 *
 */
public class CheckIfNumberIsASumOfPowersOfThree {

    //1 <= n <= 10^7
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
    public static void main(String[] args) {
        CheckIfNumberIsASumOfPowersOfThree c = new CheckIfNumberIsASumOfPowersOfThree();
        // 12 = 3^1 + 3^2
        //110
        assert c.checkPowersOfThree(12);
        // 91 = 3^0 + 3^2 + 3^4
        //1101
        assert c.checkPowersOfThree(91);
        //210
        assert !c.checkPowersOfThree(21);
    }
}
