package com.leiqjl;

/**
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers - Medium
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * <p>
 * Given a string n that represents a positive decimal integer,
 * return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 */
public class PartitioningIntoMinimumNumberOfDeci_BinaryNumbers {

    //1 <= n.length <= 10^5
    //n consists of only digits.
    //n does not contain any leading zeros and represents a positive integer.

    public int minPartitions(String n) {
        int maxChar = 0;
        for (char c : n.toCharArray()) {
            maxChar = Math.max(maxChar, c);
            if (maxChar == '9') {
                return 9;
            }
        }
        return maxChar - '0';
    }

    public static void main(String[] args) {
        PartitioningIntoMinimumNumberOfDeci_BinaryNumbers p = new PartitioningIntoMinimumNumberOfDeci_BinaryNumbers();
        //Input: n = "32"
        //Output: 3
        //Explanation: 10 + 11 + 11 = 32
        String str = "32";
        assert p.minPartitions(str) == 3;
        //Input: n = "82734"
        //Output: 8
        str = "82734";
        assert p.minPartitions(str) == 8;
        //Input: n = "27346209830709182346"
        //Output: 9
        str = "27346209830709182346";
        assert p.minPartitions(str) == 9;
    }
}
