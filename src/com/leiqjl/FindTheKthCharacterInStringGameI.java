package com.leiqjl;

/**
 * 3304. Find the K-th Character in String Game I - Easy
 */
public class FindTheKthCharacterInStringGameI {
    public char kthCharacter(int k) {
        return (char) ('a' + Integer.bitCount(k - 1));
    }
}
