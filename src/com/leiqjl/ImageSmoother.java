package com.leiqjl;

/**
 * 661. Image Smoother - Easy
 */
public class ImageSmoother {
    //m == img.length
    //n == img[i].length
    //1 <= m, n <= 200
    //0 <= img[i][j] <= 255
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int row = i - 1; row <= i + 1; row++) {
                    for (int col = j - 1; col <= j + 1; col++) {
                        if (row >= 0 && row < m && col >= 0 && col < n) {
                            sum += img[row][col];
                            count++;
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
