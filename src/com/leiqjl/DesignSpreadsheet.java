package com.leiqjl;

/**
 * 3484. Design Spreadsheet - Medium
 */
public class DesignSpreadsheet {
    class Spreadsheet {
        int[][] sheet;

        public Spreadsheet(int rows) {
            sheet = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int colum = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1)) - 1;
            sheet[row][colum] = value;
        }

        public void resetCell(String cell) {
            int colum = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1)) - 1;
            sheet[row][colum] = 0;
        }

        public int getValue(String formula) {
            int index = formula.indexOf('+');
            String leftStr = formula.substring(1, index);
            String rightStr = formula.substring(index + 1);
            int leftVal;
            if (Character.isLetter(leftStr.charAt(0))) {
                leftVal = sheet[Integer.parseInt(leftStr.substring(1)) - 1][leftStr.charAt(0) - 'A'];
            } else {
                leftVal = Integer.parseInt(leftStr);
            }

            int rightVal;
            if (Character.isLetter(rightStr.charAt(0))) {
                rightVal = sheet[Integer.parseInt(rightStr.substring(1)) - 1][rightStr.charAt(0) - 'A'];
            } else {
                rightVal = Integer.parseInt(rightStr);
            }
            return leftVal + rightVal;
        }
    }
}
