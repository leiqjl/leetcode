package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * 895. Maximum Frequency Stack - Hard
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 *
 * Implement the FreqStack class:
 * - FreqStack() constructs an empty frequency stack.
 * - void push(int val) pushes an integer val onto the top of the stack.
 * - int pop() removes and returns the most frequent element in the stack.
 * - If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 */
public class MaximumFrequencyStack {
    class FreqStack {
        HashMap<Integer, Integer> keyToFreq;
        HashMap<Integer, Deque<Integer>> freqToStack;
        int maxFreq;

        public FreqStack() {
            keyToFreq = new HashMap<>();
            freqToStack = new HashMap<>();
        }

        public void push(int val) {
            int freq = keyToFreq.getOrDefault(val, 0);
            freq++;
            keyToFreq.put(val, freq);
            Deque<Integer> stack = freqToStack.get(freq);
            if (stack == null) {
                stack = new ArrayDeque<>();
                freqToStack.put(freq, stack);
            }
            stack.push(val);
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        public int pop() {
            if (maxFreq == 0) {
                return -1;
            }
            Deque<Integer> stack = freqToStack.get(maxFreq);
            int pop = stack.pop();
            keyToFreq.put(pop, maxFreq-1);
            if (stack.isEmpty()) {
                maxFreq--;
            }
            return pop;
        }
    }

    public static void main(String[] args) {
        //Input
        //["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
        //[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
        //Output
        //[null, null, null, null, null, null, null, 5, 7, 5, 4]
    }
}
