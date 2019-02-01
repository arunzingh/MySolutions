package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SubarrySumEqualsK {
    /**
     * Given an array of integers and an integer k,
     * you need to find the total number of continuous subarrays whose sum equals to k.
     * <p>
     * Example 1:
     * Input:nums = [1,1,1], k = 2
     * Output: 2
     * Note:
     * The length of the array is in range [1, 20,000].
     * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) result++;
            }
        }

        return result;
    }

    @Test
    public void test_subarraySum() {
        SubarrySumEqualsK solution = new SubarrySumEqualsK();
        Assert.assertEquals(4, solution.subarraySum(new int[]{-1, 0, 2, -2, 1, 3, 1}, 0));
        Assert.assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
    }
}
