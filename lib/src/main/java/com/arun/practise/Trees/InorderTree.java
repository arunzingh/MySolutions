package com.arun.practise.trees;

import org.junit.Test;

/**
 *
 * 897. Increasing Order Search Tree
 *
 */
public class InorderTree {
    public TreeNode increasingBST(TreeNode curr) {
        if (curr == null) {
            return curr;
        }

        TreeNode pre = getInorderPredecessor(curr);
        TreeNode right = increasingBST(curr.right);
        TreeNode left = increasingBST(curr.left);

        if (pre != null)
            pre.right = curr;

        curr.right = right;
        curr.left = null;

        return left != null ? left : curr;
    }

    private TreeNode getInorderPredecessor(TreeNode curr) {
        if (curr == null) {
            return curr;
        }

        TreeNode pre = curr.left;
        while (pre != null && pre.right != null) {
            pre = pre.right;
        }

        return pre;
    }

    @Test
    public void test_increasingBST() {
        InorderTree solution = new InorderTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        BTreePrinter.printNode(solution.increasingBST(root));
    }

    @Test
    public void test_increasingBST_t2() {
        InorderTree solution = new InorderTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(6);
        BTreePrinter.printNode(solution.increasingBST(root));
    }

    @Test
    public void test_increasingBST_t3() {
        InorderTree solution = new InorderTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        BTreePrinter.printNode(solution.increasingBST(root));
    }

    @Test
    public void test_increasingBST_t4() {
        InorderTree solution = new InorderTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        root.right.right = new TreeNode(8);

        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        BTreePrinter.printNode(solution.increasingBST(root));
    }
}
