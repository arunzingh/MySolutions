package com.arun.practise.trees;

import org.junit.Test;

public class UpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;   // node 2 left children
        root.left.right = root;         // node 2 right children
        root.left = null;
        root.right = null;
        return newRoot;
    }

    @Test
    public void test_upsideDownBinaryTree() {
        UpsideDown solution = new UpsideDown();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode result = solution.upsideDownBinaryTree(root);
        BTreePrinter.printNode(result);

    }
}
