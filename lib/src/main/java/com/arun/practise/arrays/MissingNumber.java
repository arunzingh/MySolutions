package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 *
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        result ^= nums.length;

        return result;
    }

    @Test
    public void test_missingNumber() {
        MissingNumber solution = new MissingNumber();
        Assert.assertEquals(2, solution.missingNumber(new int[] {3, 0, 1}));
        Assert.assertEquals(0, solution.missingNumber(new int[] {1}));
        Assert.assertEquals(3, solution.missingNumber(new int[] {5, 7, 2, 1, 6, 0, 4}));
    }
}
