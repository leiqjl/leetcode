package com.leiqjl;

/**
 * 2125. Number of Laser Beams in a Bank - Medium
 */
public class NumberOfLaserBeamsInABank {

    //m == bank.length
    //n == bank[i].length
    //1 <= m, n <= 500
    //bank[i][j] is either '0' or '1'.
    public int numberOfBeams(String[] bank) {
        int result = 0, lastCount = 0;
        for (String s : bank) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            if (count != 0) {
                result += (count * lastCount);
                lastCount = count;
            }
        }
        return result;
    }
}
