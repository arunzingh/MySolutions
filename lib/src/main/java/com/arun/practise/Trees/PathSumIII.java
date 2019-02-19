package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 */
public class PathSumIII {
    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        pathSumUtil(root, sum, 0, path);
        return count;
    }

    private void pathSumUtil(TreeNode curr, int target, int pathSum, List<Integer> path) {
        if (curr == null) {
            return;
        }

        path.add(curr.val);

        pathSum += curr.val;
        int sumLocal = pathSum;
        if (pathSum == target)
            count++;

        for (int i = 0; i < path.size() - 1; i++) {
            sumLocal -= path.get(i);
            if (sumLocal == target) {
                count++;
            }

        }

        pathSumUtil(curr.left, target, pathSum, path);
        pathSumUtil(curr.right, target, pathSum, path);

        path.remove(path.size() - 1);
    }

    @Test
    public void test_pathSum() {
        PathSumIII solution = new PathSumIII();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.right.right = new TreeNode(1);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.right.right = new TreeNode(11);

        BTreePrinter.printNode(root);
        Assert.assertEquals(3, solution.pathSum(root, 8));
    }

    @Test
    public void test_pathSum_t2() {
        PathSumIII solution = new PathSumIII();

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

        BTreePrinter.printNode(root);
        Assert.assertEquals(3, solution.pathSum(root, 22));
    }
}
