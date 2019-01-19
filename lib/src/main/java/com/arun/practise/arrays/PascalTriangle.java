package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    /**
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     * <p>
     * <p>
     * Input: 5
     * Output:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 0) {
            return result;
        }

        // first row is always one
        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(i - 1);
            List<Integer> row = new ArrayList<>(prev);
            row.add(0, 1);
            for (int j = 1; j < i; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(row);

        }
        return result;
    }

    /**
     * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
     * <p>
     * Note that the row index starts from 0.
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output: [1,3,3,1]
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList(rowIndex);
        result.add(1);
        for (int i = 0; i < rowIndex; i++) {
            result.add(0, 1);

            for (int j = 1; j < i + 1;j++) {
                result.set(j, result.get(j) + result.get(j+1));
            }

        }
        return result;
    }

    @Test
    public void test_getRow() {
        PascalTriangle solution = new PascalTriangle();
        Assert.assertEquals(Arrays.asList(1), solution.getRow(0));
        Assert.assertEquals(Arrays.asList(1, 1), solution.getRow(1));
        Assert.assertEquals(Arrays.asList(1, 2, 1), solution.getRow(2));
        Assert.assertEquals(Arrays.asList(1, 3, 3, 1), solution.getRow(3));
        Assert.assertEquals(Arrays.asList(1, 4, 6, 4, 1), solution.getRow(4));
    }

    @Test
    public void test_generate() {
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> result = solution.generate(5);
        for (List<Integer> row : result) {
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
}