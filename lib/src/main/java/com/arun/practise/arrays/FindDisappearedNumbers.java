package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    @Test
    public void test_findDisappearedNumbers() {
        FindDisappearedNumbers solution = new FindDisappearedNumbers();
        Assert.assertEquals(Arrays.asList(5, 6), solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        Assert.assertEquals(Arrays.asList(2, 3, 4), solution.findDisappearedNumbers(new int[]{1, 1, 1, 1}));
        Assert.assertEquals(Arrays.asList(2, 3), solution.findDisappearedNumbers(new int[]{1, 1, 1}));
        Assert.assertEquals(Collections.emptyList(), solution.findDisappearedNumbers(new int[]{1, 2, 3, 4, 5}));
    }

}
