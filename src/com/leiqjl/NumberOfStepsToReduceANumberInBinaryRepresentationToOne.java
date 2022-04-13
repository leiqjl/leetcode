package com.leiqjl;

/**
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One - Medium
 * <p>
 * Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
 * <p>
 * - If the current number is even, you have to divide it by 2.
 * <p>
 * - If the current number is odd, you have to add 1 to it.
 * <p>
 * It is guaranteed that you can always reach one for all test cases.
 */
public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

    public int numSteps(String s) {
        int res = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                res += 2;
            } else {
                res += 1;
            }
        }
        return res + carry;
    }

    public static void main(String[] args) {
        NumberOfStepsToReduceANumberInBinaryRepresentationToOne n = new NumberOfStepsToReduceANumberInBinaryRepresentationToOne();
        //Input: s = "1101"
        //Output: 6
        assert n.numSteps("1101") == 6;
        //Input: s = "10"
        //Output: 1
        assert n.numSteps("10") == 1;
        //Input: s = "1"
        //Output: 0
        assert n.numSteps("1") == 0;
    }
}
