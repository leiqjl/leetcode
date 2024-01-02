package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2610. Convert an Array Into a 2D Array With Conditions - Medium
 */
public class ConvertAnArrayIntoA2DArrayWithConditions {
    //1 <= nums.length <= 200
    //1 <= nums[i] <= nums.length
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] countArr = new int[nums.length + 1];
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            countArr[num]++;
            if (countArr[num] > result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(countArr[num] - 1).add(num);
        }
        return result;
    }
}
