package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum < target) {
                    result += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    @Test
    public void test_threeSumSmaller() {
        ThreeSumSmaller solution = new ThreeSumSmaller();
        Assert.assertEquals(3, solution.threeSumSmaller(new int[]{3, 1, 0, -2}, 4));
        Assert.assertEquals(2, solution.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}
