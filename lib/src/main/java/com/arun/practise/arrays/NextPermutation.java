package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

public class NextPermutation {

    /**
     * Implement next permutation, which rearranges numbers
     * into the lexicographically next greater permutation of numbers.
     * <p>
     * If such arrangement is not possible, it must rearrange
     * it as the lowest possible order (ie, sorted in ascending order).
     * <p>
     * The replacement must be in-place and use only constant extra memory.
     * <p>
     * Here are some examples. Inputs are in the left-hand column and
     * its corresponding outputs are in the right-hand column.
     * <p>
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }


        int i = nums.length - 1;

        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        if (i == 0) {
            // nothing to swap
            reverse(nums, 0, nums.length - 1);
        } else {
            int j = i;
            while (j < nums.length && nums[j] > nums[i - 1]) {
                j++;
            }

            swap(nums, i - 1, j - 1);
            reverse(nums, i, nums.length - 1);
        }
    }

    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    @Test
    public void test_nextPermutation() {
        NextPermutation solution = new NextPermutation();
        int[] input = new int[]{1};
        solution.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1}, input);

        input = new int[]{1, 3, 2};
        solution.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{2, 1, 3}, input);

        input = new int[]{1, 2, 3};
        solution.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1, 3, 2}, input);

        input = new int[]{3, 2, 1};
        solution.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, input);

        input = new int[]{1, 1, 5};
        solution.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1, 5, 1}, input);

        input = new int[]{9, 9, 9};
        solution.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{9, 9, 9}, input);

        input = new int[]{2, 5, 5};
        solution.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{5, 2, 5}, input);

        input = new int[]{7, 1, 8, 2, 1, 1};
        solution.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{7, 2, 1, 1, 1, 8}, input);

    }
}
