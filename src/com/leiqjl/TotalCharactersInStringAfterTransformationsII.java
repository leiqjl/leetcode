package com.leiqjl;

import java.util.List;

/**
 * 3337. Total Characters in String After Transformations II - Hard
 */
public class TotalCharactersInStringAfterTransformationsII {

    public int[][] matrixPower(int[][] a, int power, int mod) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) {
            result[i][i] = 1;
        }
        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, a, mod);
            }
            a = multiplyMatrices(a, a, mod);
            power >>= 1;
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B, int mod) {
        int n = A.length;
        int[][] C = new int[n][n];
        // 计算结果矩阵C的每个元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] = (int) ((C[i][j] + (long) A[i][k] * B[k][j]) % mod);
                }
            }
        }
        return C;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int mod = 1000000007;
        int[][] a = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                a[(i + j) % 26][i]++;
            }
        }
        a = matrixPower(a, t, mod);
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int answer = 0;
        for (int j = 0; j < 26; j++) {
            long total = 0;
            for (int i = 0; i < 26; i++) {
                total += a[i][j];
            }
            answer = (int) ((answer + (long) cnt[j] * total) % mod);
        }
        return answer;
    }

    public static void main(String[] args) {
        TotalCharactersInStringAfterTransformationsII t = new TotalCharactersInStringAfterTransformationsII();
        //Input: s = "abcyy", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]
        //Output: 7
        //Explanation:
        //
        //First Transformation (t = 1):
        //
        //'a' becomes 'b' as nums[0] == 1
        //'b' becomes 'c' as nums[1] == 1
        //'c' becomes 'd' as nums[2] == 1
        //'y' becomes 'z' as nums[24] == 1
        //'y' becomes 'z' as nums[24] == 1
        //String after the first transformation: "bcdzz"
        //Second Transformation (t = 2):
        //
        //'b' becomes 'c' as nums[1] == 1
        //'c' becomes 'd' as nums[2] == 1
        //'d' becomes 'e' as nums[3] == 1
        //'z' becomes 'ab' as nums[25] == 2
        //'z' becomes 'ab' as nums[25] == 2
        //String after the second transformation: "cdeabab"
        //Final Length of the string: The string is "cdeabab", which has 7 characters.
        assert t.lengthAfterTransformations("abcyy", 2, List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2)) == 7;
        //Input: s = "azbk", t = 1, nums = [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]
        //Output: 8
        //Explanation:
        //
        //First Transformation (t = 1):
        //
        //'a' becomes 'bc' as nums[0] == 2
        //'z' becomes 'ab' as nums[25] == 2
        //'b' becomes 'cd' as nums[1] == 2
        //'k' becomes 'lm' as nums[10] == 2
        //String after the first transformation: "bcabcdlm"
        //Final Length of the string: The string is "bcabcdlm", which has 8 characters.
        assert t.lengthAfterTransformations("azbk", 1, List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)) == 8;
        assert t.lengthAfterTransformations("x", 16, List.of(6, 6, 8, 1, 9, 9, 10, 3, 9, 4, 8, 5, 2, 8, 10, 2, 6, 8, 2, 3, 3, 7, 2, 6, 4, 2)) == 417796858;

    }
}
