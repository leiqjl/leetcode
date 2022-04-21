package com.leiqjl;

/**
 * 705. Design HashSet - Easy
 */
public class DesignHashSet {
    //0 <= key <= 10^6
    //At most 104 calls will be made to add, remove, and contains.
    class MyHashSet {
        int[] a;

        public MyHashSet() {
            a = new int[1_000_000 / 32 + 1];
        }

        public void add(int key) {
            a[index(key)] |= mask(key);
        }

        public void remove(int key) {
            a[index(key)] &= (~mask(key));
        }

        public boolean contains(int key) {
            return (a[index(key)] & mask(key)) != 0;
        }

        private int index(int key) {
            return key / 32;
        }

        private int mask(int key) {
            return 1 << (key % 32);
        }
    }
}
