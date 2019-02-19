package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }


        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        int incl = root.val;

        // left + root
        // right + root
        // left + right + root
        // root

        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) {
            incl += left + right;
        }

        if (left != Integer.MIN_VALUE) {
            left += root.val;
        }

        if (right != Integer.MIN_VALUE){
            right += root.val;
        }

        incl = Math.max(left, Math.max(right, incl));
        return Math.max(incl, root.val);

    }

    @Test
    public void test_maxPathSum() {
        MaximumPathSum solution = new MaximumPathSum();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Assert.assertEquals(6, solution.maxPathSum(root));
    }

    @Test
    public void test_maxPathSum_t2() {
        MaximumPathSum solution = new MaximumPathSum();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(42, solution.maxPathSum(root));
    }
}
