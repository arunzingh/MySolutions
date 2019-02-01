package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * Example:
 * <p>
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;


        boolean flag = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (flag) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }

            flag = !flag;
        }
    }


    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    @Test
    public void test_wiggleSort() {
        WiggleSort solution = new WiggleSort();
        int[] input = new int[]{3, 5, 2, 1, 6, 4};
        solution.wiggleSort(input);
        System.out.println(Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{3, 5, 1, 6, 2, 4}, input);
    }

    @Test
    public void test_wiggleSort_t2() {
        WiggleSort solution = new WiggleSort();
        int[] input = new int[]{2, 1};
        solution.wiggleSort(input);
        System.out.println(Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{1, 2}, input);
    }

    @Test
    public void test_wiggleSort_t3() {
        WiggleSort solution = new WiggleSort();
        int[] input = new int[]{1, 2};
        solution.wiggleSort(input);
        System.out.println(Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{1, 2}, input);
    }

    @Test
    public void test_wiggleSort_t4() {
        WiggleSort solution = new WiggleSort();
        int[] input = new int[]{1};
        solution.wiggleSort(input);
        System.out.println(Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{1}, input);
    }

    @Test
    public void test_wiggleSort_t5() {
        WiggleSort solution = new WiggleSort();
        int[] input = new int[]{1, 2, 3};
        solution.wiggleSort(input);
        System.out.println(Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{1, 3, 2}, input);
    }

    @Test
    public void test_wiggleSort_t6() {
        WiggleSort solution = new WiggleSort();
        int[] input = new int[]{3, 2, 1};
        solution.wiggleSort(input);
        System.out.println(Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{2, 3, 1}, input);
    }
}
