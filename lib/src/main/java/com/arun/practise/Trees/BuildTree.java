package com.arun.practise.trees;

import org.junit.Test;

public class BuildTree {

    TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeUtil(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode buildTreeUtil(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        TreeNode n = null;
        if (inStart <= inEnd) {
            n = new TreeNode(postorder[postEnd]);

            int index = search(inorder, inStart, inEnd, postorder[postEnd]);
            int leftSize = index - inStart;
            n.left = buildTreeUtil(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
            n.right = buildTreeUtil(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        }

        return n;
    }

    int search(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test_buildTree() {
        BuildTree solution = new BuildTree();
        TreeNode res = solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        BTreePrinter.printNode(res);
    }
}
