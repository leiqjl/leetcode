package com.leiqjl;

import java.util.HashMap;
import java.util.List;

/**
 * 2780. Minimum Index of a Valid Split - Medium
 */
public class MinimumIndexOfAValidSplit {

    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^9
    //nums has exactly one dominant element.

    //Boyer-Moore Majority Voting Algorithm
    public int minimumIndex(List<Integer> nums) {
        int dominant = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                dominant = num;
                count = 1;
            } else if (num == dominant) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == dominant) {
                count++;
            }
        }
        int leftCount = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            if (leftCount * 2 > (i + 1) && (count - leftCount) * 2 > (nums.size() - i - 1)) {
                return i;
            }
        }
        return -1;
    }

    public int minimumIndex1(List<Integer> nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int dominant = -1, count = 0;
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if (freqMap.get(num) > count) {
                dominant = num;
                count = freqMap.get(num);
            }
        }
        int curCount = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == dominant) {
                curCount++;
            }
            if (curCount * 2 > (i + 1) && (count - curCount) * 2 > (nums.size() - i - 1)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumIndexOfAValidSplit m = new MinimumIndexOfAValidSplit();
        //Input: nums = [1,2,2,2]
        //Output: 2
        //Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2].
        //In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3.
        //In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
        //Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split.
        //It can be shown that index 2 is the minimum index of a valid split.
        assert m.minimumIndex(List.of(1, 2, 2, 2)) == 2;
        //Input: nums = [2,1,3,1,1,1,7,1,2,1]
        //Output: 4
        //Explanation: We can split the array at index 4 to obtain arrays [2,1,3,1,1] and [1,7,1,2,1].
        //In array [2,1,3,1,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
        //In array [1,7,1,2,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
        //Both [2,1,3,1,1] and [1,7,1,2,1] have the same dominant element as nums, so this is a valid split.
        //It can be shown that index 4 is the minimum index of a valid split.
        assert m.minimumIndex(List.of(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)) == 4;
        //Input: nums = [3,3,3,3,7,2,2]
        //Output: -1
        //Explanation: It can be shown that there is no valid split.
        assert m.minimumIndex(List.of(3, 3, 3, 3, 7, 2, 2)) == -1;
    }
}
