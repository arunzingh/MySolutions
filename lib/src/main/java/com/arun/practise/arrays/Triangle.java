package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int[] result = new int[1];
        result[0] = Integer.MAX_VALUE;
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();

        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = Integer.MAX_VALUE;
            }
        }
        minimumTotalUtil(triangle, 0, 0, mem, 0, result);
        return result[0];
    }

    private void minimumTotalUtil(List<List<Integer>> triangle, int level, int index, int[][] mem, int pathSum, int[] minSumSoFar) {

        List<Integer> row = triangle.get(level);

        int value = pathSum + row.get(index);

        if (value > mem[level][index]) {
            // we have shorter path from top to this node, so no need of this path
            return;
        }
        mem[level][index] = value;

        if (level == triangle.size() - 1) {
            minSumSoFar[0] = Math.min(minSumSoFar[0], value);
            return;
        }

        minimumTotalUtil(triangle, level + 1, index, mem, value, minSumSoFar);
        minimumTotalUtil(triangle, level + 1, index + 1, mem, value, minSumSoFar);
    }

    @Test
    public void test_minimumTotal() {
        Triangle solution = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        Assert.assertEquals(11, solution.minimumTotal(triangle));
    }

    @Test
    public void test_minimumTotal_t2() {
        Triangle solution = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        Assert.assertEquals(-1, solution.minimumTotal(triangle));
    }
}
