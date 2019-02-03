package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

public class UniquePaths {


    public int uniquePaths(int m, int n) {

        int[][] dp = new int[n][m];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[n-1][m-1];
    }



    @Test
    public void test_uniquePaths() {
        UniquePaths solution = new UniquePaths();

        Assert.assertEquals(3, solution.uniquePaths(3, 2));
        Assert.assertEquals(28, solution.uniquePaths(7, 3));
//
    }
}
