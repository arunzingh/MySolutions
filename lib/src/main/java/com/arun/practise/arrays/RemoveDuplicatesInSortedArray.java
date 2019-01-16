package com.arun.practise.arrays;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 */

public class RemoveDuplicatesInSortedArray {

    public int removeDuplicates(int[] nums) {
        int k = 0;

        int currIndex = 0;

        while (currIndex < nums.length) {
            while (currIndex < nums.length - 1 && nums[currIndex] == nums[currIndex + 1]) {
                currIndex++;
            }

            swap(nums, currIndex, k);
            k++;
            currIndex++;
        }

        return k;
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Test
    public void test_removeDuplicates() {
        RemoveDuplicatesInSortedArray solution = new RemoveDuplicatesInSortedArray();
        int[] input = new int[] {1, 1, 2};
        Assert.assertEquals(2, solution.removeDuplicates(input));
        System.out.println(Arrays.toString(input));

        input = new int[] {0,0,1,1,1,2,2,3,3,4};

        Assert.assertEquals(5, solution.removeDuplicates(input));
        System.out.println(Arrays.toString(input));

    }
}
