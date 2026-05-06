package com.leiqjl;

import java.util.Arrays;

/**
 * 1861. Rotating the Box - Medium
 * You are given an m x n matrix of characters boxGrid representing a side-view of a box. Each cell of the box is one of the following:
 * <p>
 * A stone '#'
 * A stationary obstacle '*'
 * Empty '.'
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
 * <p>
 * It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.
 * <p>
 * Return an n x m matrix representing the box after the rotation described above.
 */
public class RotatingTheBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] newBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            int a = n - 1;
            int b = a;
            while (a >= 0) {
                if (boxGrid[i][a] == '*') {
                    newBox[a][m - 1 - i] = '*';
                    a--;
                    b = a;
                } else if (boxGrid[i][a] == '#') {
                    newBox[a][m - 1 - i] = '.';
                    newBox[b][m - 1 - i] = '#';
                    a--;
                    b--;
                } else {
                    newBox[a][m - 1 - i] = '.';
                    a--;
                }
            }
        }
        return newBox;
    }

    public static void main(String[] args) {
        RotatingTheBox r = new RotatingTheBox();
        //Input: boxGrid = [["#",".","#"]]
        //Output: [["."],
        //         ["#"],
        //         ["#"]]
        assert Arrays.deepEquals(r.rotateTheBox(new char[][]{
                {'#', '.', '#'}}), new char[][]{
                {'.'},
                {'#'},
                {'#'}});
        //Input: boxGrid = [["#",".","*","."],
        //              ["#","#","*","."]]
        //Output: [["#","."],
        //         ["#","#"],
        //         ["*","*"],
        //         [".","."]]
        assert Arrays.deepEquals(r.rotateTheBox(new char[][]{
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}}), new char[][]{
                {'#', '.'},
                {'#', '#'},
                {'*', '*'},
                {'.', '.'}
        });
    }
}
