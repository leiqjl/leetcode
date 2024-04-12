package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 950. Reveal Cards In Increasing Order - Medium
 */
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            deque.add(i);
        }
        int[] result = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            result[deque.remove()] = deck[i];
            if (i != deck.length - 1) {
                deque.add(deque.remove());
            }
        }
        return result;
    }

}
