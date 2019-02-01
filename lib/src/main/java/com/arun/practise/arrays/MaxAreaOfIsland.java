package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array.
 * (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0)
            return result;

        int m = grid.length;
        int n = grid[0].length;

        int[][] mem = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    mem[i][j] = 0;
                } else if (grid[i][j] == 1) {
                    int left = j > 0 ? mem[i][j - 1] : 0;
                    int top = i > 0 ? mem[i - 1][j] : 0;
                    int right = j < n - 1 ? mem[i][j + 1] : 0;
                    int bottom = i < m - 1 ? mem[i + 1][j] : 0;

                    mem[i][j] = Math.max(left, Math.max(top, Math.max(right, bottom))) + 1;
                }

                result = Math.max(result, mem[i][j]);
            }
        }

        System.out.println("********** DP ************");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(mem[i]));
        }

        return result;
    }

    @Test
    public void test_maxAreaOfIsland() {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] input = new int[2][2];
        input[0] = new int[]{1, 0};
        input[1] = new int[]{0, 0};
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        Assert.assertEquals(1, solution.maxAreaOfIsland(input));
    }

    @Test
    public void test_maxAreaOfIsland_t2() {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] input = new int[2][2];
        input[0] = new int[]{1, 1};
        input[1] = new int[]{0, 0};
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        Assert.assertEquals(2, solution.maxAreaOfIsland(input));
    }

    @Test
    public void test_maxAreaOfIsland_t3() {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] input = new int[2][2];
        input[0] = new int[]{1, 0};
        input[1] = new int[]{0, 1};
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        Assert.assertEquals(1, solution.maxAreaOfIsland(input));
    }

    @Test
    public void test_maxAreaOfIsland_t4() {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] input = new int[2][2];
        input[0] = new int[]{1, 1};
        input[1] = new int[]{0, 1};
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        Assert.assertEquals(3, solution.maxAreaOfIsland(input));
    }

    @Test
    public void test_maxAreaOfIsland_t5() {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] input = new int[2][2];
        input[0] = new int[]{1, 1};
        input[1] = new int[]{1, 1};
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        Assert.assertEquals(3, solution.maxAreaOfIsland(input));
    }

    @Test
    public void test_maxAreaOfIsland_t6() {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] input = new int[3][3];
        input[0] = new int[]{1, 0, 1};
        input[1] = new int[]{1, 1, 1};
        input[2] = new int[]{0, 0, 1};
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }

        Assert.assertEquals(6, solution.maxAreaOfIsland(input));
    }
}
