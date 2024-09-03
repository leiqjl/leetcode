package com.leiqjl;

/**
 * 1894. Find the Student that Will Replace the Chalk - Medium
 */
public class FindTheStudentThatWillReplaceTheChalk {

    //Constraints:
    //
    //chalk.length == n
    //1 <= n <= 10^5
    //1 <= chalk[i] <= 10^5
    //1 <= k <= 10^9
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for (int num : chalk) {
            sum += num;
            if (sum > k) {
                break;
            }
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        FindTheStudentThatWillReplaceTheChalk f = new FindTheStudentThatWillReplaceTheChalk();
        //Input: chalk = [5,1,5], k = 22
        //Output: 0
        assert f.chalkReplacer(new int[]{5, 1, 5}, 22) == 0;
        //Input: chalk = [3,4,1,2], k = 25
        //Output: 1
        assert f.chalkReplacer(new int[]{3, 4, 1, 2}, 25) == 1;
    }
}
