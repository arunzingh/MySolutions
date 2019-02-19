package com.arun.practise.arrays;

import org.junit.Test;

import java.util.Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean isFirstColumnZero = false;
        boolean isFirstRowZero = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isFirstColumnZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    @Test
    public void test_setZeroes() {
        SetMatrixZeros solution = new SetMatrixZeros();
        // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        int[][] input = new int[3][4];
        input[0] = new int[]{0, 1, 2, 0};
        input[1] = new int[]{3, 4, 5, 2};
        input[2] = new int[]{1, 3, 1, 5};
        solution.setZeroes(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }

    @Test
    public void test_setZeroes_t2() {
        SetMatrixZeros solution = new SetMatrixZeros();
        // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        int[][] input = new int[3][1];
        input[0] = new int[]{1};
        input[1] = new int[]{0};
        input[2] = new int[]{3};
        solution.setZeroes(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }
}
