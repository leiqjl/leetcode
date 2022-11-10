package com.leiqjl;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 901. Online Stock Span - Medium
 */
public class OnlineStockSpan {
    class StockSpanner {
        Deque<int[]> stack;

        public StockSpanner() {
            stack = new LinkedList<>();
        }

        public int next(int price) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{price, count});
            return count;
        }
    }
}
