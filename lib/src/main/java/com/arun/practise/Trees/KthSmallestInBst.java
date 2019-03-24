package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class KthSmallestInBst {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                k--;
                if (k == 0) {
                    return curr.val;
                }
                curr = curr.right;
            }
        }

        return -1;
    }

    @Test
    public void test_kthSmallest() {
        KthSmallestInBst solution = new KthSmallestInBst();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);
        Assert.assertEquals(1, solution.kthSmallest(root, 1));
        Assert.assertEquals(2, solution.kthSmallest(root, 2));
        Assert.assertEquals(3, solution.kthSmallest(root, 3));
        Assert.assertEquals(4, solution.kthSmallest(root, 4));
    }

    @Test
    public void test_kthSmallest_t2() {
        KthSmallestInBst solution = new KthSmallestInBst();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Assert.assertEquals(1, solution.kthSmallest(root, 1));
        Assert.assertEquals(2, solution.kthSmallest(root, 2));
        Assert.assertEquals(3, solution.kthSmallest(root, 3));
        Assert.assertEquals(4, solution.kthSmallest(root, 4));
        Assert.assertEquals(5, solution.kthSmallest(root, 5));
        Assert.assertEquals(6, solution.kthSmallest(root, 6));
    }
}
