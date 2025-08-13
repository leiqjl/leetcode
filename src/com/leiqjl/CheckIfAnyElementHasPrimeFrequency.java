package com.leiqjl;

/**
 * 591. Check if Any Element Has Prime Frequency - Easy
 */
public class CheckIfAnyElementHasPrimeFrequency {

    //Constraints:
    //
    //1 <= nums.length <= 100
    //0 <= nums[i] <= 100
    public boolean checkPrimeFrequency(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 0; i < 101; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] == 2 || freq[i] == 3 || freq[i] == 5 || freq[i] == 7) {
                return true;
            }
            if (freq[i] == 1 || freq[i] % 2 == 0 || freq[i] % 3 == 0 || freq[i] % 5 == 0 || freq[i] % 7 == 0) {
                continue;
            }
            return true;
        }
        return false;
    }
}
