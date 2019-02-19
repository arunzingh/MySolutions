package com.arun.practise.trees;



import com.sun.tools.javac.util.Pair;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        return maxDepthRecur(root, 0);
    }

    private int maxDepthRecur(TreeNode curr, int d) {
        if (curr == null) {
            return d;
        }

        return Math.max(maxDepthRecur(curr.left, d + 1), maxDepthRecur(curr.right, d + 1));
    }


    private int maxDepthIterative(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(Pair.of(root, 1));
        int maxDepth = Integer.MIN_VALUE;

        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> entry = stack.pop();
            TreeNode curr = entry.fst;
            int d = entry.snd;
            maxDepth = Math.max(maxDepth, d);
            if (curr.left != null) {
                stack.push(Pair.of(curr.left, d + 1));
            }

            if (curr.right != null) {
                stack.push(Pair.of(curr.right, d + 1));
            }
        }

        return maxDepth;
    }

    @Test
    public void test_maxDepth() {
        MaximumDepth solution = new MaximumDepth();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(3, solution.maxDepth(root));
    }

    @Test
    public void test_maxDepthIterative() {
        MaximumDepth solution = new MaximumDepth();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(3, solution.maxDepthIterative(root));
    }
}
