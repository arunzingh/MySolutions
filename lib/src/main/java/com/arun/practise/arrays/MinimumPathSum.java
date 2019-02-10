package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // top left, just copy from grid
                    dp[i][j] = grid[i][j];
                } else if (i == 0 && j > 0) {
                    // first row, keep adding from left as there's no way from top
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    // first colum, keep adding from top as there's no way from left
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    @Test
    public void test_minPathSum() {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] input = new int[3][3];
        input[0] = new int[]{1, 3, 1};
        input[1] = new int[]{1, 5, 1};
        input[2] = new int[]{4, 2, 1};

        Assert.assertEquals(7, solution.minPathSum(input));
    }
}
