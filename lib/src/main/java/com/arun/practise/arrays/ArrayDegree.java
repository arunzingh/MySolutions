package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums,
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * <p>
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * <p>
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 */
public class ArrayDegree {

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        Map<Integer, Degree> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Degree d = map.get(nums[i]);
                d.count++;
                d.end = i;
                map.put(nums[i], d);
            } else {
                Degree d = new Degree(1, i, i);
                map.put(nums[i], d);
            }
        }

        int maxFrequency = Integer.MIN_VALUE;
        int length = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Degree> entry : map.entrySet()) {
            if (entry.getValue().count > maxFrequency) {
                maxFrequency = entry.getValue().count;
                length = entry.getValue().end - entry.getValue().start + 1;
            } else if (entry.getValue().count == maxFrequency) {
                length = Math.min(length, entry.getValue().end - entry.getValue().start + 1);
            }
        }

        return length;
    }

    class Degree {
        int count;
        int start;
        int end;

        public Degree(int count, int start, int end) {
            this.count = count;
            this.start = start;
            this.end = end;
        }
    }

    @Test
    public void test_findShortestSubArray() {
        ArrayDegree solution = new ArrayDegree();
        Assert.assertEquals(6, solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        Assert.assertEquals(2, solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
