package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array A of non-negative integers, r
 * eturn an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            while (i < j && nums[i] % 2 == 0) {
                i++;
            }

            while (i < j && nums[j] % 2 == 1) {
                j--;
            }

            swap(nums, i, j);
            i++;
            j--;

        }

        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    @Test
    public void test_sortArrayByParity() {
        SortArrayByParity solution = new SortArrayByParity();
        Assert.assertArrayEquals(new int[]{4, 2, 1, 3}, solution.sortArrayByParity(new int[]{3, 1, 2, 4}));
        Assert.assertArrayEquals(new int[]{2, 4}, solution.sortArrayByParity(new int[]{2, 4}));
        Assert.assertArrayEquals(new int[]{1, 3}, solution.sortArrayByParity(new int[]{1, 3}));
        Assert.assertArrayEquals(new int[]{1}, solution.sortArrayByParity(new int[]{1}));
        Assert.assertArrayEquals(new int[]{2, 1, 3}, solution.sortArrayByParity(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{2, 1, 3}, solution.sortArrayByParity(new int[]{2, 1, 3}));
        Assert.assertArrayEquals(new int[]{2, 1, 3}, solution.sortArrayByParity(new int[]{3, 1, 2}));
    }
}
