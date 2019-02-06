package com.arun.practise.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    /**
     * Given a collection of distinct integers, return all possible permutations.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * Output:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUtil(nums, 0, result);
        return result;
    }

    private void permuteUtil(int[] nums, int k, List<List<Integer>> result) {
        if (k == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int n : nums) {
                list.add(n);
            }
            result.add(list);
        } else {
            for (int i = k; i < nums.length; i++) {
                swap(nums, i, k);
                permuteUtil(nums, k + 1, result);
                swap(nums, i, k);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUniqueUtil(nums, new ArrayList<Integer>(), result, visited);
        return result;
    }

    private void permuteUniqueUtil(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] visited) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            current.add(nums[i]);
            permuteUniqueUtil(nums, current, result, visited);
            visited[i] = false;
            current.remove(current.size() - 1);

            while (i < nums.length - 1 && nums[i] == nums[i+1])
                i++;

        }
    }




    @Test
    public void test_permuteUnique() {
        Permutation solution = new Permutation();
        List<List<Integer>> result = solution.permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }

    @Test
    public void test_permuteUnique_t2() {
        Permutation solution = new Permutation();
        List<List<Integer>> result = solution.permuteUnique(new int[]{0, 1, 0, 0, 9});

        // expected : [[0,0,0,1,9],[0,0,0,9,1],[0,0,1,0,9],[0,0,1,9,0],[0,0,9,0,1],[0,0,9,1,0],
        // [0,1,0,0,9],[0,1,0,9,0],[0,1,9,0,0],[0,9,0,0,1],[0,9,0,1,0],[0,9,1,0,0],[1,0,0,0,9],
        // [1,0,0,9,0],[1,0,9,0,0],[1,9,0,0,0],[9,0,0,0,1],[9,0,0,1,0],[9,0,1,0,0],[9,1,0,0,0]]

        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }

    @Test
    public void test_permuteUnique_t3() {
        Permutation solution = new Permutation();
        List<List<Integer>> result = solution.permuteUnique(new int[]{2, 2, 1, 1});

        // expected : [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]

        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }


    @Test
    public void test_permute() {
        Permutation solution = new Permutation();
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> row : result) {
            System.out.println(row.toString());
        }
    }


}
