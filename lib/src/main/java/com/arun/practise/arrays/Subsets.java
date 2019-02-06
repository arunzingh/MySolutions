package com.arun.practise.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums,
 * return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsetUtil(nums, 0, result, current);
        return result;
    }

    private void subsetUtil(int[] nums, int start, List<List<Integer>> result, List<Integer> current) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            subsetUtil(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        subsetUtilWithDup(nums, 0, result, current);

        return result;
    }

    private void subsetUtilWithDup(int[] nums, int start, List<List<Integer>> result, List<Integer> current) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            subsetUtilWithDup(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }


    @Test
    public void test_subsets() {
        Subsets solution = new Subsets();
        List<List<Integer>> result = solution.subsets(new int[]{1, 2, 3});
        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }

    @Test
    public void test_subsetsWithDup() {
        Subsets solution = new Subsets();
        List<List<Integer>> result = solution.subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }

    @Test
    public void test_subsetsWithDup_t2() {
        Subsets solution = new Subsets();
        List<List<Integer>> result = solution.subsetsWithDup(new int[]{1, 2, 1});
        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }
}
