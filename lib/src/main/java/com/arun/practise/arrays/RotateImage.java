package com.arun.practise.arrays;

import org.junit.Test;

public class RotateImage {

    /**
     * You are given an n x n 2D matrix representing an image.
     * <p>
     * Rotate the image by 90 degrees (clockwise).
     * <p>
     * Note:
     * You have to rotate the image in-place,
     * which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     * <p>
     * Example 1:
     * <p>
     * Given input matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * Example 2:
     * <p>
     * Given input matrix =
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {

            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // top
                int temp = matrix[first][i];

                //
                matrix[first][i] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = temp;
            }
        }
    }

    @Test
    public void test_rotate() {
        RotateImage solution = new RotateImage();

        int[][] input = new int[3][3];
        input[0] = new int[]{1, 2, 3};
        input[1] = new int[]{4, 5, 6};
        input[2] = new int[]{7, 8, 9};

        solution.rotate(input);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + " ");
            }

            System.out.println();
        }
    }

    @Test
    public void test_rotate_t2() {
        RotateImage solution = new RotateImage();

        int[][] input = new int[4][4];
        input[0] = new int[]{5, 1, 9, 11};
        input[1] = new int[]{2, 4, 8, 10};
        input[2] = new int[]{13, 3, 6, 7};
        input[3] = new int[]{15, 14, 12, 16};

        solution.rotate(input);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + " ");
            }

            System.out.println();
        }
    }
}
