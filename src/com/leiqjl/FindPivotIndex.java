package com.leiqjl;

/**
 * 724. Find Pivot Index - Easy
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex f = new FindPivotIndex();
        assert f.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}) == 3;
        assert f.pivotIndex(new int[]{1, 2, 3}) == -1;
        assert f.pivotIndex(new int[]{2, 1, -1}) == 0;
    }

}
