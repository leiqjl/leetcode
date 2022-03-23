package com.leiqjl;

/**
 * 991. Broken Calculator - Medium
 * <p>
 * There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
 * - multiply the number on display by 2, or
 * - subtract 1 from the number on display.
 * Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.
 */
public class BrokenCalculator {

    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while (startValue < target) {
            if ((target & 1) == 1) {
                target++;
            } else {
                target >>= 1;
            }
            count++;
        }
        return count + startValue - target;
    }

    public static void main(String[] args) {
        BrokenCalculator b = new BrokenCalculator();
        //Input: startValue = 2, target = 3
        //Output: 2
        //{2 -> 4 -> 3}
        assert b.brokenCalc(2, 3) == 2;
        //Input: startValue = 5, target = 8
        //Output: 2
        //{5 -> 4 -> 8}.
        assert b.brokenCalc(5, 8) == 2;
        //Input: startValue = 3, target = 10
        //Output: 3
        //{3 -> 6 -> 5 -> 10}.
        assert b.brokenCalc(3, 10) == 3;
    }
}
