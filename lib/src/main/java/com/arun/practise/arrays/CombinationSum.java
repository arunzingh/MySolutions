package com.arun.practise.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>(candidates.length);
        Arrays.sort(candidates);
        combinationSumUtil(candidates, target, 0, current, result);
        return result;
    }

    private void combinationSumUtil(int[] candidates, int target, int k, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = k; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinationSumUtil(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * https://leetcode.com/problems/combination-sum-ii/
     * <p>
     * Given a collection of candidate numbers (candidates) and a target number (target),
     * find all unique combinations in candidates where the candidate numbers sums to target.
     * <p>
     * Each number in candidates may only be used once in the combination.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * Example 2:
     * <p>
     * Input: candidates = [2,5,2,1,2], target = 5,
     * A solution set is:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>(candidates.length);
        Arrays.sort(candidates);
        combinationSumUtil2(candidates, target, 0, current, result);
        return result;
    }

    private void combinationSumUtil2(int[] candidates, int target, int k, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = k; i < candidates.length; i++) {
            if (i > k && candidates[i] == candidates[i - 1]) continue;

            current.add(candidates[i]);
            combinationSumUtil2(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    @Test
    public void test_combinationSum2() {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);

        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }

    @Test
    public void test_combinationSum2_t2() {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);

        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }

    @Test
    public void test_combinationSum() {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);

        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }

    @Test
    public void test_combinationSum_t2() {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(new int[]{2, 3, 5}, 8);

        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }
}
