package com.leiqjl;

/**
 * 3005. Count Elements With Maximum Frequency - Easy
 */
public class CountElementsWithMaximumFrequency {
    //Constraints:
    //
    //1 <= nums.length <= 100
    //1 <= nums[i] <= 100
    public int maxFrequencyElements(int[] nums) {
        int[] freqArr = new int[101];
        int maxFreq = 0;
        int count = 0;
        for (int num : nums) {
            freqArr[num]++;
            int freq = freqArr[num];
            if (freq > maxFreq) {
                maxFreq = freq;
                count = freq;
            } else if (freq == maxFreq) {
                count += freq;
            }
        }
        return count;
    }
}
