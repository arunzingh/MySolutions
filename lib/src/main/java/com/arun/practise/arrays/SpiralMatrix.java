package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    /**
     * Given a matrix of m x n elements (m rows, n columns),
     * return all elements of the matrix in spiral order.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * <p>
     * Input:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;
        int left = 0;

        while (top <= bottom && left <= right) {

            int j = left;
            while (j <= right) {
                result.add(matrix[top][j]);
                j++;
            }
            top++;

            int i = top;
            while (i <= bottom) {
                result.add(matrix[i][right]);
                i++;
            }
            right--;


            j = right;
            while (bottom >= top && j >= left) {
                result.add(matrix[bottom][j]);
                j--;
            }
            bottom--;


            i = bottom;
            while (left <= right && i >= top) {
                result.add(matrix[i][left]);
                i--;
            }
            left++;
        }

        return result;
    }

    @Test
    public void test_spiralOrder() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] input = new int[3][3];
        input[0] = new int[]{1, 2, 3};
        input[1] = new int[]{4, 5, 6};
        input[2] = new int[]{7, 8, 9};
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(input));
    }

    @Test
    public void test_spiralOrder_t2() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] input = new int[4][4];
        input[0] = new int[]{1, 2, 3, 4};
        input[1] = new int[]{5, 6, 7, 8};
        input[2] = new int[]{9, 10, 11, 12};
        input[3] = new int[]{13, 14, 15, 16};
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), solution.spiralOrder(input));
    }

    @Test
    public void test_spiralOrder_t3() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] input = new int[3][4];
        input[0] = new int[]{1, 2, 3, 4};
        input[1] = new int[]{5, 6, 7, 8};
        input[2] = new int[]{9, 10, 11, 12};
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), solution.spiralOrder(input));
    }

    @Test
    public void test_spiralOrder_t4() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] input = new int[4][3];
        input[0] = new int[]{1, 2, 3};
        input[1] = new int[]{4, 5, 6};
        input[2] = new int[]{7, 8, 9};
        input[3] = new int[]{10, 11, 12};
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8), solution.spiralOrder(input));
    }


    @Test
    public void test_spiralOrder_t5() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] input = new int[1][10];
        input[0] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), solution.spiralOrder(input));
    }

    @Test
    public void test_spiralOrder_t6() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] input = new int[10][1];
        input[0] = new int[]{1};
        input[1] = new int[]{2};
        input[2] = new int[]{3};
        input[3] = new int[]{4};
        input[4] = new int[]{5};
        input[5] = new int[]{6};
        input[6] = new int[]{7};
        input[7] = new int[]{8};
        input[8] = new int[]{9};
        input[9] = new int[]{10};
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), solution.spiralOrder(input));
    }

    @Test
    public void test_spiralOrder_t7() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] input = new int[2][2];
        input[0] = new int[]{1, 2};
        input[1] = new int[]{3, 4};
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3), solution.spiralOrder(input));
    }

    @Test
    public void test_spiralOrder_t8() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] input = new int[2][3];
        input[0] = new int[]{1, 2, 3};
        input[1] = new int[]{4, 5, 6};
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 5, 4), solution.spiralOrder(input));
    }


    /**
     * Given a positive integer n,
     * generate a square matrix filled with elements from 1 to n2 in spiral order.
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {

        int[][] output = new int[n][n];

        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;

        int counter = 1;
        while (top <= bottom && left <= right) {

            int j = left;
            while (j <= right) {
                output[top][j] = counter;
                counter++;
                j++;
            }
            top++;

            int i = top;
            while (i <= bottom) {
                output[i][right] = counter;
                counter++;
                i++;
            }
            right--;

            j = right;
            while (bottom >= top && j >= left) {
                output[bottom][j] = counter;
                counter++;
                j--;
            }
            bottom--;

            i = bottom;
            while (left <= right  && i >= top) {
                output[i][left] = counter;
                counter++;
                i--;
            }
            left++;


        }
        return output;
    }

    @Test
    public void test_generateMatrix() {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] result = solution.generateMatrix(3);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
