package com.leiqjl;

/**
 * 3003. Maximize the Number of Partitions After Operations - Hard
 * You are given a string s and an integer k.
 * <p>
 * First, you are allowed to change at most one index in s to another lowercase English letter.
 * <p>
 * After that, do the following partitioning operation until s is empty:
 * <p>
 * ·Choose the longest prefix of s containing at most k distinct characters.
 * ·Delete the prefix from s and increase the number of partitions by one. The remaining characters (if any) in s maintain their initial order.
 * Return an integer denoting the maximum number of resulting partitions after the operations by optimally choosing at most one index to change.
 */
public class MaximizeTheNumberOfPartitionsAfterOperations {


    public int maxPartitionsAfterOperations(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        //段数 字母数 bitmask
        int[][] leftArr = new int[n][3];
        int[][] rightArr = new int[n][3];
        int num = 0;
        int count = 0;
        int mask = 0;
        for (int i = 0; i < n - 1; i++) {
            int b = 1 << (chars[i] - 'a');
            if ((mask & b) == 0) {
                count++;
                if (count <= k) {
                    mask |= b;
                } else {
                    num++;
                    mask = b;
                    count = 1;
                }
            }
            leftArr[i + 1][0] = num;
            leftArr[i + 1][1] = count;
            leftArr[i + 1][2] = mask;
        }
        num = 0;
        count = 0;
        mask = 0;
        for (int i = n - 1; i > 0; i--) {
            int b = (1 << (chars[i] - 'a'));
            if ((mask & b) == 0) {
                count++;
                if (count <= k) {
                    mask |= b;
                } else {
                    num++;
                    mask = b;
                    count = 1;
                }
            }
            rightArr[i - 1][0] = num;
            rightArr[i - 1][1] = count;
            rightArr[i - 1][2] = mask;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = leftArr[i][0] + rightArr[i][0] + 2;
            int totalMask = leftArr[i][2] | rightArr[i][2];
            int totalCount = Integer.bitCount(totalMask);
            if ((leftArr[i][1] == k) && (rightArr[i][1] == k) && totalCount < 26) {
                sum++;
            } else if (Math.min(totalCount + 1, 26) <= k) {
                sum--;
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }


    public static void main(String[] args) {
        MaximizeTheNumberOfPartitionsAfterOperations m = new MaximizeTheNumberOfPartitionsAfterOperations();
        //The optimal way is to change s[2] to something other than a and c, for example, b. then it becomes "acbca".
        //
        //Then we perform the operations:
        //
        //The longest prefix containing at most 2 distinct characters is "ac", we remove it and s becomes "bca".
        //Now The longest prefix containing at most 2 distinct characters is "bc", so we remove it and s becomes "a".
        //Finally, we remove "a" and s becomes empty, so the procedure ends.
        //Doing the operations, the string is divided into 3 partitions, so the answer is 3.
        assert m.maxPartitionsAfterOperations("accca", 2) == 3;
        //Initially s contains 2 distinct characters, so whichever character we change,
        // it will contain at most 3 distinct characters,
        // so the longest prefix with at most 3 distinct characters would always be all of it, therefore the answer is 1.
        assert m.maxPartitionsAfterOperations("aabaab", 3) == 1;
        //The optimal way is to change s[0] or s[1] to something other than characters in s, for example, to change s[0] to w.
        //Then s becomes "wxyz", which consists of 4 distinct characters, so as k is 1, it will divide into 4 partitions.
        assert m.maxPartitionsAfterOperations("xxyz", 1) == 4;
        assert m.maxPartitionsAfterOperations("tzaxomrbtieqpkduclsjhdyxonfwwbnbqgbvdxaqhbip", 26) == 1;
    }
}
