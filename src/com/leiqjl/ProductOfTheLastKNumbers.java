package com.leiqjl;

import java.util.ArrayList;

/**
 * 1352. Product of the Last K Numbers - Medium
 * Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.
 * <p>
 * Implement the ProductOfNumbers class:
 * <p>
 * ·ProductOfNumbers() Initializes the object with an empty stream.
 * ·void add(int num) Appends the integer num to the stream.
 * ·int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.
 * <p>
 * The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 */
public class ProductOfTheLastKNumbers {

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        assert productOfNumbers.getProduct(2) == 20; // return 20. The product of the last 2 numbers is 5 * 4 = 20
        assert productOfNumbers.getProduct(3) == 40; // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        assert productOfNumbers.getProduct(4) == 0; // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        assert productOfNumbers.getProduct(2) == 32; // return 32. The product of the last 2 numbers is 4 * 8 = 32

    }

}

class ProductOfNumbers {
    private ArrayList<Integer> list;
    private int size;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
        size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            list.add(1);
            size = 0;
        } else {
            list.add(num * list.get(size));
            size++;
        }
    }

    public int getProduct(int k) {
        if (k <= size) {
            return list.get(size) / list.get(size - k);
        }
        return 0;
    }
}
