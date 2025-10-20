package com.leiqjl;

/**
 * 2011. Final Value of Variable After Performing Operations - Easy
 * There is a programming language with only four operations and one variable X:
 * <p>
 * · ++X and X++ increments the value of the variable X by 1.
 * · --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 * <p>
 * Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
 */
public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
