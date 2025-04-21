package com.leiqjl;

/**
 * 2145. Count the Hidden Sequences - Medium
 */
public class CountTheHiddenSequences {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int max = 0, min = 0;
        int cur = 0;
        for (int diff : differences) {
            cur += diff;
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            if ((max - min) > (upper - lower)) {
                return 0;
            }
        }
        return (upper - lower) - (max - min) + 1;
    }

    public static void main(String[] args) {
        CountTheHiddenSequences c = new CountTheHiddenSequences();
        //Input: differences = [1,-3,4], lower = 1, upper = 6
        //Output: 2
        //Explanation: The possible hidden sequences are:
        //- [3, 4, 1, 5]
        //- [4, 5, 2, 6]
        //Thus, we return 2.
        assert c.numberOfArrays(new int[]{1, -3, 4}, 1, 6) == 2;
        //Input: differences = [3,-4,5,1,-2], lower = -4, upper = 5
        //Output: 4
        //Explanation: The possible hidden sequences are:
        //- [-3, 0, -4, 1, 2, 0]
        //- [-2, 1, -3, 2, 3, 1]
        //- [-1, 2, -2, 3, 4, 2]
        //- [0, 3, -1, 4, 5, 3]
        //Thus, we return 4.
        assert c.numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5) == 4;
        //Input: differences = [4,-7,2], lower = 3, upper = 6
        //Output: 0
        //Explanation: There are no possible hidden sequences. Thus, we return 0.
        assert c.numberOfArrays(new int[]{4, -7, 2}, 3, 6) == 0;
        assert c.numberOfArrays(new int[]{-40}, -46, 53) == 60;
    }
}
