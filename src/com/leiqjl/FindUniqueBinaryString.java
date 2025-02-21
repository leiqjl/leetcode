package com.leiqjl;

/**
 * 1980. Find Unique Binary String - Medium
 * <p>
 * Given an array of strings nums containing n unique binary strings each of length n,
 * return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
 */
public class FindUniqueBinaryString {
    //Constraints:
    //
    //n == nums.length
    //1 <= n <= 16
    //nums[i].length == n
    //nums[i] is either '0' or '1'.
    //All the strings of nums are unique.
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            stringBuilder.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return stringBuilder.toString();
    }
}
