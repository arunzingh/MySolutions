package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {

    public int maximalRectangle(int[][] matrix) {
        int result = 0;
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int[] row = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[j] = 0;
                } else {
                    row[j] = row[j] + 1;
                }
            }

            int largest = largestRectangleArea(row);

            result = Math.max(result, largest);
        }


        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;

        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int index = 0;

        while (!stack.isEmpty() || index < heights.length) {

            if (stack.isEmpty() || (index < heights.length
                    && heights[stack.peek()] < heights[index])) {
                stack.push(index);
                index++;
                continue;
            }


            int j = stack.pop();
            int area = 0;
            if (stack.isEmpty()) {
                area = heights[j] * index;
            } else {
                area = heights[j] * (index - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    public int maximalRectangleDP(int[][] matrix) {
        int maxArea = 0;
        if (matrix == null || matrix.length == 0)
            return 0;

        int M = matrix.length;
        int N = matrix[0].length;

        int[] height = new int[N];

        // left[i] records the left most boundary index j satisfying any k from j to i, height[k] >= height[i]
        // right[i] records the right most boundary index j satisfying any k from i to j, height[k] >= height[i]
        int[] left = new int[N];
        int[] right = new int[N];

        Arrays.fill(right, N - 1);

        for (int i = 0; i < M; i++) {

            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] = height[j] + 1;
                }
            }

            int currLeftBoundary = 0;
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    left[j] = 0;
                    // boundary should at least start from next index
                    currLeftBoundary = j + 1;
                } else {
                    left[j] = Math.max(left[j], currLeftBoundary);
                }
            }

            int currRightBoundary = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    right[j] = N - 1;
                    currRightBoundary = j - 1;
                } else {
                    right[j] = Math.min(right[j], currRightBoundary);
                }
            }


            for (int j = 0; j < N; j++) {
                maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
            }
        }


        return maxArea;
    }

    @Test
    public void test_maximalRectangle() {
        MaximalRectangle solution = new MaximalRectangle();

        int[][] input = new int[4][5];
        //                   0  1  2  3  4
        input[0] = new int[]{1, 0, 1, 0, 0};
        input[1] = new int[]{1, 0, 1, 1, 1};
        input[2] = new int[]{1, 1, 1, 1, 1};
        input[3] = new int[]{1, 0, 0, 1, 0};

        Assert.assertEquals(6, solution.maximalRectangle(input));
    }

    @Test
    public void test_maximalRectangleDP() {
        MaximalRectangle solution = new MaximalRectangle();

        int[][] input = new int[4][5];
        input[0] = new int[]{1, 0, 1, 0, 0};
        input[1] = new int[]{1, 0, 1, 1, 1};
        input[2] = new int[]{1, 1, 1, 1, 1};
        input[3] = new int[]{1, 0, 0, 1, 0};

        Assert.assertEquals(6, solution.maximalRectangleDP(input));
    }
}
