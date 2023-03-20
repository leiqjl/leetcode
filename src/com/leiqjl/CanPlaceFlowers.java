package com.leiqjl;

/**
 * 605. Can Place Flowers - Medium
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int countZero = 1, count = 0;
        for (int f : flowerbed) {
            if (f == 0) {
                countZero++;
            } else {
                count += (countZero - 1) / 2;
                countZero = 0;
            }
        }
        count += countZero / 2;
        return count >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        int[] flowerbed = {1, 0, 0, 0, 1};
        assert c.canPlaceFlowers(flowerbed, 1);
        assert !c.canPlaceFlowers(flowerbed, 2);
        assert c.canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1);
    }
}
