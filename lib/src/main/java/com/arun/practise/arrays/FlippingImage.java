package com.arun.practise.arrays;


import org.junit.Test;

import java.util.Arrays;

/**
 * Given a binary matrix A, we want to flip the image horizontally,
 * then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * <p>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {

        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j * 2 < n; j++) {
                if (A[i][j] == A[i][n - j - 1]) {
                    A[i][n - j - 1] ^= 1;
                    A[i][j] = A[i][n - j - 1];
                }
            }
        }

        return A;
    }


    @Test
    public void test_flipAndInvertImage() {
        FlippingImage solution = new FlippingImage();
        int[][] input = new int[3][3];
        input[0] = new int[]{1, 1, 0};
        input[1] = new int[]{1, 0, 1};
        input[2] = new int[]{0, 0, 0};

        int[][] result = solution.flipAndInvertImage(input);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }


    @Test
    public void test_flipAndInvertImage_t2() {
        FlippingImage solution = new FlippingImage();
        // [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
        int[][] input = new int[4][4];
        input[0] = new int[]{1,1,0,0};
        input[1] = new int[]{1,0,0,1};
        input[2] = new int[]{0,1,1,1};
        input[3] = new int[]{1,0,1,0};

        // [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

        int[][] result = solution.flipAndInvertImage(input);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
