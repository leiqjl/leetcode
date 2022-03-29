package com.leiqjl;

/**
 * 307. Range Sum Query - Mutable  - Medium
 */
public class RangeSumQuery_Mutable {

    public static void main(String[] args) {
        //["NumArray","sumRange","update","sumRange"]
        //[[[1,3,5]],[0,2],[1,2],[0,2]]
        int[] nums = {1, 3, 5};
        NumArray n = new NumArray(nums);
        assert n.sumRange(0, 2) == 9;
        n.update(1, 2);
        assert n.sumRange(0, 2) == 8;
    }
}

class NumArray {
    int[] sums;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            updateDiff(i, nums[i]);
        }
    }
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateDiff(index,  diff);
    }

    public void updateDiff(int index, int diff) {
        index++;
        for (int i = index; i < sums.length; i += (i & -i)) {
            sums[i] += diff;
        }
    }

    public int sum(int index) {
        index++;
        int sum = 0;
        for (int i = index; i > 0; i -= (i & -i)) {
            sum += sums[i];
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}