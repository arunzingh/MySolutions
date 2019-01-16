package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 *
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = nums.length - 1;

        int i = 0;
        while (i <= k) {
            if (nums[i] == val) {
                nums[i] = nums[k];
                k--;
                continue;
            }
            i++;
        }

        return i;
    }

    @Test
    public void test_removeElement() {
        RemoveElement solution = new RemoveElement();
        int[] input = new int[] {3,2,2,3};
        Assert.assertEquals(2, solution.removeElement(input, 3));
        System.out.println(Arrays.toString(input));

        input = new int[] {0,1,2,2,3,0,4,2};

        Assert.assertEquals(5, solution.removeElement(input, 2));
        System.out.println(Arrays.toString(input));

        input = new int[] {1};

        Assert.assertEquals(1, solution.removeElement(input, 2));
        System.out.println(Arrays.toString(input));

        input = new int[] {2};

        Assert.assertEquals(0, solution.removeElement(input, 2));
        System.out.println(Arrays.toString(input));

        input = new int[] {3, 3};

        Assert.assertEquals(2, solution.removeElement(input, 5));
        System.out.println(Arrays.toString(input));
    }
}
