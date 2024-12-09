package com.leiqjl;

import java.util.Arrays;

/**
 * 179. Largest Number - Medium
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    //Constraints:
    //
    //1 <= nums.length <= 100
    //0 <= nums[i] <= 10^9
    public String largestNumber(int[] nums) {
        String[] strArray = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strArray, (a, b) -> (b + a).compareTo(a + b));
        if (strArray[0].equals("0")) {
            return "0";
        }
        return String.join("", strArray);
    }

    public static void main(String[] args) {
        LargestNumber l = new LargestNumber();
        //Input: nums = [10,2]
        //Output: "210"
        assert "210".equals(l.largestNumber(new int[]{10, 2}));
        //Input: nums = [3,30,34,5,9]
        //Output: "9534330"
        assert "9534330".equals(l.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
