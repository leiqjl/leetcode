package com.leiqjl;

import java.util.Arrays;

/**
 * 945. Minimum Increment to Make Array Unique - Medium
 */
public class MinimumIncrementToMakeArrayUnique {

    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //0 <= nums[i] <= 10^5
    // count sort timeO(max+n) spaceO(max+n)
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] counts = new int[max + n];
        for (int num : nums) {
            counts[num]++;
        }
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1) {
                int diff = counts[i] - 1;
                counts[i + 1] += diff;
                res += diff;
            }
        }
        return res;
    }

    // sort time O(nlogn) space O(1)
    public int minIncrementForUnique1(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count += (nums[i - 1] + 1 - nums[i]);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique m = new MinimumIncrementToMakeArrayUnique();
        //Input: nums = [1,2,2]
        //Output: 1
        //Explanation: After 1 move, the array could be [1, 2, 3].
        assert m.minIncrementForUnique(new int[]{1, 2, 2}) == 1;
        //Input: nums = [3,2,1,2,1,7]
        //Output: 6
        //Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
        //It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
        assert m.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}) == 6;
    }
}
