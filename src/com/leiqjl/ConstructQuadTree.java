package com.leiqjl;

/**
 * 427. Construct Quad Tree - Medium
 */
public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }
        Node root = new Node();
        int newLen = len / 2;
        Node topLeft = construct(grid, x, y, newLen);
        Node topRight = construct(grid, x, y + newLen, newLen);
        Node bottomLeft = construct(grid, x + newLen, y, newLen);
        Node bottomRight = construct(grid, x + newLen, y + newLen, newLen);
        boolean isLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topRight.val == bottomRight.val && bottomRight.val == bottomLeft.val;
        if (isLeaf) {
            root.isLeaf = true;
            root.val = topLeft.val;
        } else {
            root.topRight = topRight;
            root.topLeft = topLeft;
            root.bottomRight = bottomRight;
            root.bottomLeft = bottomLeft;
        }
        return root;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
