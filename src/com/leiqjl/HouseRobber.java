package com.leiqjl;

/**
 * 198. House Robber - Medium
 */
public class HouseRobber {

    public int rob(int[] nums) {
        int oneStepBefore = 0;
        int twoStepBefore = 0;
        for (int num : nums) {
            int temp = oneStepBefore;
            oneStepBefore = Math.max(oneStepBefore, twoStepBefore + num);
            twoStepBefore = temp;
        }
        return oneStepBefore;
    }

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        assert h.rob(new int[]{1, 2, 3, 1}) == 4;
        assert h.rob(new int[]{2, 7, 9, 3, 1}) == 12;
        assert h.rob(new int[]{2, 7, 9, 3, 1, 4}) == 15;
    }
}
