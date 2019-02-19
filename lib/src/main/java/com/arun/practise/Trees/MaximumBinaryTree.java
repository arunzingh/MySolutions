package com.arun.practise.trees;

import org.junit.Test;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeUtil(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTreeUtil(int[] nums, int left, int right) {
        TreeNode node = null;
        if (left <= right) {

            if (left == right) {
                return new TreeNode(nums[left]);
            }

            int max = left;
            for (int i = left; i <= right; i++) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
            }

            node = new TreeNode(nums[max]);
            node.left = constructMaximumBinaryTreeUtil(nums, left, max - 1);
            node.right = constructMaximumBinaryTreeUtil(nums, max + 1, right);
        }
        return node;
    }

    @Test
    public void test_constructMaximumBinaryTree() {
        MaximumBinaryTree solution = new MaximumBinaryTree();
        TreeNode node = solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        BTreePrinter.printNode(node);
    }
}
