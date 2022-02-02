package com.leiqjl;

/**
 *   287. Find the Duplicate Number
 *
 *   Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 *   There is only one repeated number in nums, return this repeated number.
 *
 *   You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindTheDuplicateNumber {


    /**
     * time  O(n)
     * space O(1)
     * @see LinkedListCycleII#detectCycle(ListNode)
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate1(int[] nums) {
        boolean[] a = new boolean[nums.length];
        int i = 0;
        while (!a[nums[i]]) {
            a[nums[i]] = true;
            i++;
        }
        return nums[i];
    }

}
