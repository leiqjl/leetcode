package com.leiqjl;

import java.util.Arrays;

/**
 * 1033. Moving Stones Until Consecutive - Medium
 */
public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        if (arr[2] - arr[0] == 2) {
            return new int[]{0, 0};
        }
        //  (xy__z  x_y___z) 1    x___y___z  2
        int min = Math.min(arr[1] - arr[0], arr[2] - arr[1]) <= 2 ? 1 : 2;
        int max = arr[2] - arr[0] - 1 - 1;
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        MovingStonesUntilConsecutive m = new MovingStonesUntilConsecutive();
        //Input: a = 1, b = 2, c = 5
        //Output: [1,2]
        //Explanation: Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
        assert "[1, 2]".equals(Arrays.toString(m.numMovesStones(1, 2, 5)));
        //Input: a = 4, b = 3, c = 2
        //Output: [0,0]
        //Explanation: We cannot make any moves.
        assert "[0, 0]".equals(Arrays.toString(m.numMovesStones(4, 3, 2)));
        //Input: a = 3, b = 5, c = 1
        //Output: [1,2]
        //Explanation: Move the stone from 1 to 4; or move the stone from 1 to 2 to 4.
        assert "[1, 2]".equals(Arrays.toString(m.numMovesStones(3, 5, 1)));
    }
}
