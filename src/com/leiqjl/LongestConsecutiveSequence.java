package com.leiqjl;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence - Medium
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 1;
            while (set.contains(num + 1)) {
                num++;
                len++;
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }

    //0 <= nums.length <= 10^5
    //-10^9 <= nums[i] <= 10^9
    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        //Input: nums = [100,4,200,1,3,2]
        //Output: 4
        //Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
        int[] nums = {100, 4, 200, 1, 3, 2};
        assert l.longestConsecutive(nums) == 4;
        //Input: nums = [0,3,7,2,5,8,4,6,0,1]
        //Output: 9
        int[] nums1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assert l.longestConsecutive(nums1) == 9;
    }
}
