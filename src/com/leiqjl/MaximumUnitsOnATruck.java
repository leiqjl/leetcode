package com.leiqjl;

/**
 * 1710. Maximum Units on a Truck - Easy
 * <p>
 * You are assigned to put some amount of boxes onto one truck.
 * You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 * <p>
 * - numberOfBoxesi is the number of boxes of type i.
 * - numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * <p>
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
 * You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 * <p>
 * Return the maximum total number of units that can be put on the truck.
 */
public class MaximumUnitsOnATruck {

    //1 <= boxTypes.length <= 1000
    //1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
    //1 <= truckSize <= 10^6

    // O(n) O(1001)==O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] bucket = new int[1001];
        for (int[] boxType : boxTypes) {
            bucket[boxType[1]] += boxType[0];
        }
        int count = 0;
        for (int i = 1000; i >= 0; i--) {
            if (bucket[i] == 0) {
                continue;
            }
            if (bucket[i] < truckSize) {
                count += bucket[i] * i;
                truckSize -= bucket[i];
            } else {
                count += truckSize * i;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumUnitsOnATruck m = new MaximumUnitsOnATruck();
        //Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
        //Output: 8
        //Explanation: There are:
        //- 1 box of the first type that contains 3 units.
        //- 2 boxes of the second type that contain 2 units each.
        //- 3 boxes of the third type that contain 1 unit each.
        //You can take all the boxes of the first and second types, and one box of the third type.
        //The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        assert m.maximumUnits(boxTypes, 4) == 8;
        //Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
        //Output: 91
        int[][] boxTypes1 = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        assert m.maximumUnits(boxTypes1, 10) == 91;
    }
}
