package com.leiqjl;

/**
 * 1079. Letter Tile Possibilities - Medium
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 * <p>
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 */
public class LetterTilePossibilities {
    //Constraints:
    //
    //1 <= tiles.length <= 7
    //tiles consists of uppercase English letters.
    public int numTilePossibilities(String tiles) {
        int[] countArr = new int[26];
        for (char c : tiles.toCharArray()) {
            countArr[c - 'A']++;
        }

        return count(countArr);
    }

    private int count(int[] countArr) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (countArr[i] == 0) {
                continue;
            }
            count++;
            countArr[i]--;
            count += count(countArr);
            countArr[i]++;
        }
        return count;
    }

    public static void main(String[] args) {
        LetterTilePossibilities l = new LetterTilePossibilities();
        //The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
        assert l.numTilePossibilities("AAB") == 8;
        assert l.numTilePossibilities("AAABBC") == 188;
        assert l.numTilePossibilities("V") == 1;
    }
}
