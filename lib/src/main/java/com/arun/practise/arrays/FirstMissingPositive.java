package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    @Test
    public void test_firstMissingPositive() {
        FirstMissingPositive solution = new FirstMissingPositive();
        Assert.assertEquals(2, solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        Assert.assertEquals(3, solution.firstMissingPositive(new int[]{1, 2, 0}));
        Assert.assertEquals(1, solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
