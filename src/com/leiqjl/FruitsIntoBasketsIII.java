package com.leiqjl;

/**
 * 3479. Fruits Into Baskets III - Medium
 */
public class FruitsIntoBasketsIII {
    private void build(int p, int l, int r, int[] baskets, int[] segTree) {
        if (l == r) {
            segTree[p] = baskets[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(p << 1, l, mid, baskets, segTree);
        build((p << 1) | 1, mid + 1, r, baskets, segTree);
        segTree[p] = Math.max(segTree[p << 1], segTree[(p << 1) | 1]);
    }

    private boolean query(int p, int l, int r, int target, int[] segTree) {
        if (segTree[p] < target) {
            return false;
        }
        if (l == r) {
            segTree[p] = -1;
            return true;
        }
        boolean placed;
        int mid = (l + r) >> 1;
        if (segTree[p << 1] >= target) {
            placed = query(p << 1, l, mid, target, segTree);
        } else {
            placed = query((p << 1) | 1, mid + 1, r, target, segTree);
        }
        segTree[p] = Math.max(segTree[p << 1], segTree[(p << 1) | 1]);
        return placed;
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] segTree = new int[n * 4 + 1];
        build(1, 0, n - 1, baskets, segTree);
        int count = 0;
        for (int fruit : fruits) {
            if (!query(1, 0, n - 1, fruit, segTree)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FruitsIntoBasketsIII f = new FruitsIntoBasketsIII();
        //Input: fruits = [4,2,5], baskets = [3,5,4]
        //Output: 1
        assert f.numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}) == 1;
        //Input: fruits = [3,6,1], baskets = [6,4,7]
        //Output: 0
        assert f.numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7}) == 0;
    }
}