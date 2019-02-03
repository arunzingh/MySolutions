package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array nums containing n + 1 integers
 * where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * <p>
 * Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int result = 0;

        if (nums == null || nums.length == 0) {
            return result;
        }


        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;

        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);

        return slow;
    }

    @Test
    public void test_findDuplicate() {
        FindDuplicateNumber solution = new FindDuplicateNumber();
        Assert.assertEquals(2, solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        Assert.assertEquals(3, solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
