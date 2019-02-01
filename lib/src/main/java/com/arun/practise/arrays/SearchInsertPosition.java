package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[left] == target || nums[left] > target ? left : left + 1;
    }

    @Test
    public void test_searchInsert() {
        SearchInsertPosition solution = new SearchInsertPosition();

        Assert.assertEquals(0, solution.searchInsert(new int[]{1}, 1));
        Assert.assertEquals(0, solution.searchInsert(new int[]{3}, 1));
        Assert.assertEquals(1, solution.searchInsert(new int[]{4}, 5));
        Assert.assertEquals(0, solution.searchInsert(new int[]{3, 4}, 1));
        Assert.assertEquals(2, solution.searchInsert(new int[]{3, 4}, 5));
        Assert.assertEquals(0, solution.searchInsert(new int[]{3, 4, 5}, 1));
        Assert.assertEquals(3, solution.searchInsert(new int[]{3, 4, 5}, 7));
        Assert.assertEquals(1, solution.searchInsert(new int[]{3, 4, 5}, 4));
        Assert.assertEquals(2, solution.searchInsert(new int[]{3, 4, 5}, 5));
        Assert.assertEquals(0, solution.searchInsert(new int[]{3, 4, 5}, 3));
    }
}
