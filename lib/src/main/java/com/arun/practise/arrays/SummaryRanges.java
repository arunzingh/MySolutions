package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            String range = null;
            if (num == nums[i]) {
                range = String.valueOf(num);
            } else {
                range = num + "->" + nums[i];
            }
            result.add(range);
        }

        System.out.println(result);
        return result;
    }

    @Test
    public void test_summaryRanges() {
        SummaryRanges solution = new SummaryRanges();
        List<String> expected = Arrays.asList("0->2", "4->5", "7");
        Assert.assertEquals(expected, solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));

        expected = Arrays.asList("1->5");
        Assert.assertEquals(expected, solution.summaryRanges(new int[]{1, 2, 3, 4, 5}));

        expected = Arrays.asList("1", "3", "5", "7");
        Assert.assertEquals(expected, solution.summaryRanges(new int[]{1, 3, 5, 7}));

        expected = Arrays.asList("0", "2->4", "6", "8->9");
        Assert.assertEquals(expected, solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

}
