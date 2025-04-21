package com.leiqjl;

/**
 * 781. Rabbits in Forest - Medium
 */
public class RabbitsInForest {
    //Constraints:
    //
    //1 <= answers.length <= 1000
    //0 <= answers[i] < 1000
    public int numRabbits(int[] answers) {
        int[] freq = new int[1001];
        int num = 0;
        for (int ans : answers) {
            freq[ans]++;
            if (freq[ans] == 1) {
                num += (ans + 1);
            }
            if (freq[ans] == ans + 1) {
                freq[ans] = 0;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        RabbitsInForest r = new RabbitsInForest();
        assert r.numRabbits(new int[]{1, 1, 2}) == 5;
        assert r.numRabbits(new int[]{10, 10, 10}) == 11;
        assert r.numRabbits(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}) == 11;
    }
}
