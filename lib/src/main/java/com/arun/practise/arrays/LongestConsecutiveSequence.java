package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int result = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return result;
        }

        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int counter = 1;
                int num = nums[i];
                while(set.contains(num + 1)) {
                    num++;
                    counter++;
                }
                result = Math.max(result, counter);
            }
        }

        return result;
    }

    @Test
    public void test_longestConsecutive() {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        Assert.assertEquals(4, solution.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }
}
