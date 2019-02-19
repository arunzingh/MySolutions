package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree and a sum,
 * find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        List<Integer> path = new ArrayList<>();
        pathSumUtil(root, sum, path, results);
        return results;
    }

    private void pathSumUtil(TreeNode curr, int sum, List<Integer> path, List<List<Integer>> results) {
        if (curr == null) {
            return;
        }

        path.add(curr.val);

        if (sum == curr.val && curr.left == null && curr.right == null) {
            results.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        pathSumUtil(curr.left, sum - curr.val, path, results);
        pathSumUtil(curr.right, sum - curr.val, path, results);
        path.remove(path.size() - 1);
    }

    @Test
    public void test_pathSum() {
        PathSumII solution = new PathSumII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(5, 4, 11, 2));
        expected.add(Arrays.asList(5, 8, 4, 5));

        Assert.assertEquals(expected, solution.pathSum(root, 22));
    }

    @Test
    public void test_pathSum_t2() {
        PathSumII solution = new PathSumII();
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-2, -3));

        Assert.assertEquals(expected, solution.pathSum(root, -5));
    }
}
