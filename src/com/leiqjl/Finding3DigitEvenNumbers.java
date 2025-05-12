package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2094. Finding 3-Digit Even Numbers - Easy
 */
public class Finding3DigitEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int num = 100; num < 999; num += 2) {
            int i = num / 100, j = num / 10 % 10, k = num % 10;
            freq[i]--;
            freq[j]--;
            freq[k]--;
            if (freq[i] >= 0 && freq[j] >= 0 && freq[k] >= 0) {
                list.add(num);
            }
            freq[i]++;
            freq[j]++;
            freq[k]++;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Finding3DigitEvenNumbers f = new Finding3DigitEvenNumbers();
        //Input: digits = [2,1,3,0]
        //Output: [102,120,130,132,210,230,302,310,312,320]
        assert Arrays.equals(f.findEvenNumbers(new int[]{2, 1, 3, 0}), new int[]{102, 120, 130, 132, 210, 230, 302, 310, 312, 320});
        //Input: digits = [2,2,8,8,2]
        //Output: [222,228,282,288,822,828,882]
        assert Arrays.equals(f.findEvenNumbers(new int[]{2, 2, 8, 8, 2}), new int[]{222, 228, 282, 288, 822, 828, 882});
        //Input: digits = [3,7,5]
        //Output: []
        assert Arrays.equals(f.findEvenNumbers(new int[]{3, 7, 5}), new int[]{});
    }
}
