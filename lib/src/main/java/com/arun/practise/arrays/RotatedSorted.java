package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

public class RotatedSorted {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return true, otherwise return false.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     * <p>
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                System.out.println("index=" + mid);
                return true;
            }

            if (nums[left] < nums[mid]) {
                // left is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // search left
                    right = mid - 1;
                } else {
                    // search right
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                // right is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // search right
                    left = mid + 1;
                } else {
                    // search left
                    right = mid - 1;
                }
            } else {
                if (nums[left] == nums[mid] && nums[mid] != nums[right]) {
                    // left is same, right different so search right
                    left = mid + 1;
                } else if (nums[mid] == nums[right] && nums[left] != nums[mid]) {
                    // right is same, left is different so search left
                    right = mid - 1;
                } else {
                    // no option search all
                    // eg: [1 2 1 1 1 1]
                    left++;
                    right--;
                }
            }
        }

        return false;
    }

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // left is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // search left
                    right = mid - 1;
                } else {
                    // search right
                    left = mid + 1;
                }
            } else {
                // right is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // search right
                    left = mid + 1;
                } else {
                    // search left
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     * <p>
     * Find the minimum element.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,4,5,1,2]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,5,6,7,0,1,2]
     * Output: 0
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid > left && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (mid < right && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[left] > nums[mid]) {
                // go left
                right = mid - 1;
            } else {
                // go right
                left = mid + 1;
            }
        }

        // happens when given array is not rotated
        return nums[0];
    }


    public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid > left && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (mid < right && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[left]) {
                // go left
                right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                // go left
                left = mid + 1;
            } else {
                //
                right--;
            }
        }

        // happens when given array is not rotated
        return nums[0];
    }


    @Test
    public void test_findMin2() {
        RotatedSorted solution = new RotatedSorted();

        Assert.assertEquals(1, solution.findMin2(new int[]{3, 3, 3, 1}));
        Assert.assertEquals(1, solution.findMin2(new int[]{1,3,5}));
        Assert.assertEquals(0, solution.findMin2(new int[]{2,2,2,0,1}));
        Assert.assertEquals(0, solution.findMin2(new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
        Assert.assertEquals(1, solution.findMin2(new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(1, solution.findMin2(new int[]{5, 1, 2, 3, 4}));
        Assert.assertEquals(2, solution.findMin2(new int[]{5, 2, 3}));
        Assert.assertEquals(2, solution.findMin2(new int[]{3, 2}));
        Assert.assertEquals(1, solution.findMin2(new int[]{1, 3}));
        Assert.assertEquals(0, solution.findMin2(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    public void test_findMin() {
        RotatedSorted solution = new RotatedSorted();

        Assert.assertEquals(3, solution.findMin(new int[]{3, 4, 5, 6, 7}));
        Assert.assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(0, solution.findMin(new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
        Assert.assertEquals(1, solution.findMin(new int[]{5, 1, 2, 3, 4}));
        Assert.assertEquals(2, solution.findMin(new int[]{5, 2, 3}));
        Assert.assertEquals(2, solution.findMin(new int[]{3, 2}));
        Assert.assertEquals(1, solution.findMin(new int[]{1, 3}));
        Assert.assertEquals(0, solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }


    @Test
    public void test_search() {
        RotatedSorted solution = new RotatedSorted();
        Assert.assertEquals(1, solution.search(new int[]{5, 1, 2, 3, 4}, 1));
        Assert.assertEquals(-1, solution.search(new int[]{5, 1, 3}, 0));
        Assert.assertEquals(1, solution.search(new int[]{3, 1}, 1));
        Assert.assertEquals(-1, solution.search(new int[]{1, 3}, 0));
        Assert.assertEquals(1, solution.search(new int[]{1, 3}, 3));
        Assert.assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assert.assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        Assert.assertEquals(2, solution.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        Assert.assertEquals(-1, solution.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 8));
    }

    @Test
    public void test_search2() {
        RotatedSorted solution = new RotatedSorted();

        Assert.assertEquals(true, solution.search2(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        Assert.assertEquals(false, solution.search2(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        Assert.assertEquals(true, solution.search2(new int[]{1, 3, 1, 1, 1}, 3));
        Assert.assertEquals(true, solution.search2(new int[]{5, 1, 2, 3, 4}, 1));
        Assert.assertEquals(false, solution.search2(new int[]{5, 1, 3}, 0));
        Assert.assertEquals(true, solution.search2(new int[]{3, 1}, 1));
        Assert.assertEquals(false, solution.search2(new int[]{1, 3}, 0));
        Assert.assertEquals(true, solution.search2(new int[]{1, 3}, 3));
        Assert.assertEquals(true, solution.search2(new int[]{4, 5, 6, 7, 0, 0, 0, 1, 2}, 0));
        Assert.assertEquals(false, solution.search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        Assert.assertEquals(true, solution.search2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        Assert.assertEquals(false, solution.search2(new int[]{1, 2, 3, 4, 5, 6, 7}, 8));
    }
}
