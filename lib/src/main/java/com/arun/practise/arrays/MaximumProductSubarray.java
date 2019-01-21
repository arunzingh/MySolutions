package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int prevMaxProduct = nums[0];
        int prevMinProduct = nums[0];

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int maxProduct = Math.max(Math.max(prevMaxProduct * nums[i], prevMinProduct * nums[i]), nums[i]);
            int minProduct = Math.min(Math.min(prevMaxProduct * nums[i], prevMinProduct * nums[i]), nums[i]);

            result = Math.max(result, maxProduct);

            prevMaxProduct = maxProduct;
            prevMinProduct = minProduct;
        }

        return result;
    }

    @Test
    public void test_maxProduct() {
        MaximumProductSubarray solution = new MaximumProductSubarray();
        Assert.assertEquals(24, solution.maxProduct(new int[]{2, -5, -2, -4, 3}));
        Assert.assertEquals(0, solution.maxProduct(new int[]{-2, 0, -1}));
        Assert.assertEquals(6, solution.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
