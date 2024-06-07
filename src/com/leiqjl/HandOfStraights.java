package com.leiqjl;

import java.util.HashMap;

/**
 * 846. Hand of Straights - Medium
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
 * <p>
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        for (int card : map.keySet()) {
            int start = card;
            while (map.getOrDefault(start - 1, 0) > 0) {
                start--;
            }
            while (start <= card) {
                while (map.get(start) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if (map.getOrDefault(i, 0) == 0) {
                            return false;
                        }
                        map.put(i, map.get(i) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights h = new HandOfStraights();
        //Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
        //Output: true
        //Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
        assert h.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3);
        //Input: hand = [1,2,3,4,5], groupSize = 4
        //Output: false
        //Explanation: Alice's hand can not be rearranged into groups of 4.
        assert !h.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4);
        assert !h.isNStraightHand(new int[]{8,10,12}, 3);
    }
}
