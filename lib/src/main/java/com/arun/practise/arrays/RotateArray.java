package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int d = k % nums.length;
        reverse(nums, 0, nums.length - d - 1);
        reverse(nums, nums.length - d, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    @Test
    public void test_rotate() {
        RotateArray solution = new RotateArray();
        int[] input = new int[]{1, 2, 3, 4, 5};
        solution.rotate(input, 2);
        Assert.assertArrayEquals(new int[]{4, 5, 1, 2, 3}, input);

        input = new int[]{1, 2, 3, 4, 5, 6};
        solution.rotate(input, 2);
        Assert.assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, input);

        input = new int[]{1, 2, 3, 4, 5, 6};
        solution.rotate(input, 6);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, input);

        input = new int[]{1, 2, 3, 4, 5, 6};
        solution.rotate(input, 96);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, input);
    }

}
