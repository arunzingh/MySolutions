package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSumSoFar = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closestSumSoFar)) {
                    closestSumSoFar = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSumSoFar;
    }

    @Test
    public void test_threeSumClosest() {
        ThreeSumClosest solution = new ThreeSumClosest();
        Assert.assertEquals(1, solution.threeSumClosest(new int[]{1, -3, 3, 5, 4, 1}, 1));

    }

}
