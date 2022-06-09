package com.leiqjl;

/**
 * 167. Two Sum II - Input Array Is Sorted - Medium
 */
public class TwoSumII_InputArrayIsSorted {
    //2 <= numbers.length <= 3 * 10^4
    //-1000 <= numbers[i] <= 1000
    //numbers is sorted in non-decreasing order.
    //-1000 <= target <= 1000
    //The tests are generated such that there is exactly one solution.
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
