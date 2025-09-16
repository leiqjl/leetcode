package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2197. Replace Non-Coprime Numbers in Array - Hard
 * You are given an array of integers nums. Perform the following steps:
 * <p>
 * 1.Find any two adjacent numbers in nums that are non-coprime.
 * 2.If no such numbers are found, stop the process.
 * 3.Otherwise, delete the two numbers and replace them with their LCM (Least Common Multiple).
 * 4.Repeat this process as long as you keep finding two adjacent non-coprime numbers.
 * Return the final modified array. It can be shown that replacing adjacent non-coprime numbers in any arbitrary order will lead to the same result.
 * <p>
 * The test cases are generated such that the values in the final array are less than or equal to 10^8.
 * <p>
 * Two values x and y are non-coprime if GCD(x, y) > 1 where GCD(x, y) is the Greatest Common Divisor of x and y.
 */
public class ReplaceNon_CoprimeNumbersInArray {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^5
    //The test cases are generated such that the values in the final array are less than or equal to 10^8.
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            while (result.size() > 0) {
                int top = result.get(result.size() - 1);
                int gcd = gcd(top, num);
                if (gcd > 1) {
                    result.remove(result.size() - 1);
                    num = (int)((long) top * num / gcd);
                } else {
                    break;
                }
            }
            result.add(num);
        }
        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        ReplaceNon_CoprimeNumbersInArray r = new ReplaceNon_CoprimeNumbersInArray();
        //Input: nums = [6,4,3,2,7,6,2]
        //Output: [12,7,6]
        assert r.replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2}).equals(List.of(12, 7, 6));
        //Input: nums = [2,2,1,1,3,3,3]
        //Output: [2,1,1,3]
        assert r.replaceNonCoprimes(new int[]{2, 2, 1, 1, 3, 3, 3}).equals(List.of(2, 1, 1, 3));
        assert r.replaceNonCoprimes(new int[]{31,97561,97561,97561,97561,97561,97561,97561,97561}).equals(List.of(31,97561));
    }
}
