package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinimumDaysProduce {

    public int getMinimumDays(int[] nums, int target) {

        Arrays.sort(nums);
        int day = 0;

        while (target > 0) {
            day++;

            for (int i = 0; i < nums.length; i++) {
                if (day % nums[i] == 0) {
                    target--;
                    if (target <= 0) {
                        break;
                    }
                }
            }
        }
        return day;
    }

    @Test
    public void test_getMinimumDays() {
        MinimumDaysProduce solution = new MinimumDaysProduce();
        Assert.assertEquals(8, solution.getMinimumDays(new int[]{2, 3, 2}, 10));
        Assert.assertEquals(6, solution.getMinimumDays(new int[]{1, 2, 3}, 11));
        Assert.assertEquals(30, solution.getMinimumDays(new int[]{5, 6}, 11));
    }
}
