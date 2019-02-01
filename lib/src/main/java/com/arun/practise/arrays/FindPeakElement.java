package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindPeakElement {

    /**
     * A peak element is an element that is greater than its neighbors.
     * <p>
     * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
     * <p>
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * <p>
     * You may imagine that nums[-1] = nums[n] = -∞.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     * Example 2:
     * <p>
     * Input: nums = [1,2,1,3,5,6,4]
     * Output: 1 or 5
     * Explanation: Your function can return either index number 1 where the peak element is 2,
     * or index number 5 where the peak element is 6.
     * Note:
     * <p>
     * Your solution should be in logarithmic complexity.
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (left == right - 1) {
                return nums[left] > nums[right] ? left : right;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    @Test
    public void test_findPeakElement() {
        FindPeakElement solution = new FindPeakElement();
        Assert.assertEquals(0, solution.findPeakElement(new int[]{1}));
        Assert.assertEquals(0, solution.findPeakElement(new int[]{0}));
        Assert.assertEquals(1, solution.findPeakElement(new int[]{1, 2}));
        Assert.assertEquals(0, solution.findPeakElement(new int[]{2, 1}));
        Assert.assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3}));
        Assert.assertEquals(0, solution.findPeakElement(new int[]{3, 2, 1}));
        Assert.assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(5, solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        Assert.assertEquals(6, solution.findPeakElement(new int[]{1, 3, 2, 7, 9, 13, 17}));
    }

    @Test
    public void test_findPeakElement2() {
        FindPeakElement solution = new FindPeakElement();
        Assert.assertEquals(0, solution.findPeakElement2(new int[]{1}));
        Assert.assertEquals(0, solution.findPeakElement2(new int[]{0}));
        Assert.assertEquals(1, solution.findPeakElement2(new int[]{1, 2}));
        Assert.assertEquals(0, solution.findPeakElement2(new int[]{2, 1}));
        Assert.assertEquals(2, solution.findPeakElement2(new int[]{1, 2, 3}));
        Assert.assertEquals(0, solution.findPeakElement2(new int[]{3, 2, 1}));
        Assert.assertEquals(2, solution.findPeakElement2(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(5, solution.findPeakElement2(new int[]{1, 2, 1, 3, 5, 6, 4}));
        Assert.assertEquals(6, solution.findPeakElement2(new int[]{1, 3, 2, 7, 9, 13, 17}));
    }
}
