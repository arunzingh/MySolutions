package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

public class JumpGame {

    /**
     * Given an array of non-negative integers,
     * you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Determine if you are able to reach the last index.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        dp[nums.length - 1] = 1;

        canJumpUtil(nums, dp, 0, nums.length - 1);
        return dp[0] == 1;
    }

    boolean canJumpUtil(int[] nums, int[] dp, int start, int end) {

        if (dp[start] != -1)
            return dp[start] == 1;

        int farthest = Math.min(start + nums[start], end);
        for (int j = start + 1; j <= farthest; j++) {
            if (canJumpUtil(nums, dp, j, end)) {
                dp[start] = 1;
                return true;
            }
        }
        dp[start] = 0;
        return false;
    }

    /**
     * Given an array of non-negative integers,
     * you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Your goal is to reach the last index in the minimum number of jumps.
     * <p>
     * Example:
     * <p>
     * Input: [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     * Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Note:
     * <p>
     * You can assume that you can always reach the last index.
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        return minJumpRecur(nums, 0, nums.length - 1);
    }

    private int minJumpRecur(int[] nums, int start, int end) {

        if (start == end) {
            return 0;
        }

        int farthest = Math.min(start + nums[start], end);
        int min = Integer.MAX_VALUE - 1;
        for (int j = start + 1; j <= farthest; j++) {
            int value = minJumpRecur(nums, j, end);
            min = Math.min(min, value);
        }

        return min + 1;
    }

    public boolean canJump2(int[] nums) {
        int index = 0;
        int maxReach = 0;

        while (index < nums.length && index <= maxReach) {
            maxReach = Math.max(maxReach, index + nums[index]);
            index++;
        }

        return index == nums.length;
    }

    public int jumpDp(int[] nums) {
        int[] jumps = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }
        return jumps[nums.length - 1];
    }

    
    @Test
    public void test_canJump() {
        JumpGame solution = new JumpGame();
        Assert.assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        Assert.assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void test_canJump2() {
        JumpGame solution = new JumpGame();
        Assert.assertFalse(solution.canJump2(new int[]{3, 2, 1, 0, 4}));
        Assert.assertTrue(solution.canJump2(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void test_minJump() {
        JumpGame solution = new JumpGame();
        Assert.assertEquals(3, solution.jump(new int[]{1, 1, 1, 1}));
        Assert.assertEquals(2, solution.jump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void test_minJumpDp() {
        JumpGame solution = new JumpGame();
        Assert.assertEquals(2, solution.jumpDp(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(3, solution.jumpDp(new int[]{1, 1, 1, 1}));
    }
}
