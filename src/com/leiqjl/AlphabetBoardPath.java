package com.leiqjl;

/**
 * 1138. Alphabet Board Path - Medium
 */
public class AlphabetBoardPath {

    //board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]
    //"abcde"
    //"fghij"
    //"klmno"
    //"pqrst"
    //"uvwxy"
    //"z"
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int row = 0, col = 0;
        for (char c : target.toCharArray()) {
            int nextRow = (c - 'a') / 5;
            int nextCol = (c - 'a') % 5;
            //U>R L>D
            while (nextRow < row) {
                sb.append("U");
                row--;
            }
            while (nextCol < col) {
                sb.append("L");
                col--;
            }
            while (nextRow > row) {
                sb.append("D");
                row++;
            }
            while (nextCol > col) {
                sb.append("R");
                col++;
            }
            sb.append("!");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AlphabetBoardPath a = new AlphabetBoardPath();
        //Input: target = "leet"
        //Output: "DDR!UURRR!!DDD!"
        assert a.alphabetBoardPath("leet").equals("DDR!UURRR!!DDD!");
        //Input: target = "code"
        //Output: "RR!DDRR!UUL!R!"
        assert a.alphabetBoardPath("code").equals("RR!DDRR!UUL!R!");
    }
}
