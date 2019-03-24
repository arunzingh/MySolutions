package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

public class ValidateBst {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        BTreePrinter.printNode(root);
        return isValidBSTUtil(root, null, null);
    }

    private boolean isValidBSTUtil(TreeNode curr, Integer min, Integer max) {
        if (curr == null) {
            return true;
        }

        if (min != null && curr.val <= min) {
            return false;
        }

        if (max != null && curr.val >= max) {
            return false;
        }

        return isValidBSTUtil(curr.left, min, curr.val)
                && isValidBSTUtil(curr.right, curr.val, max);
    }

    @Test
    public void test_isValidBST() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Assert.assertTrue(solution.isValidBST(root));
    }

    @Test
    public void test_isValidBST_t2() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        Assert.assertFalse(solution.isValidBST(root));

    }


    @Test
    public void test_isValidBST_t3() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);


        Assert.assertFalse(solution.isValidBST(root));

    }

    @Test
    public void test_isValidBST_t4() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        Assert.assertTrue(solution.isValidBST(root));

    }

    @Test
    public void test_isValidBST_t5() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        root.left = new TreeNode(Integer.MIN_VALUE);
        Assert.assertTrue(solution.isValidBST(root));

    }

    @Test
    public void test_isValidBST_t6() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        Assert.assertTrue(solution.isValidBST(root));

    }

    @Test
    public void test_isValidBST_t7() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.left = new TreeNode(Integer.MAX_VALUE);
        Assert.assertFalse(solution.isValidBST(root));

    }

    @Test
    public void test_isValidBST_t8() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        root.right = new TreeNode(Integer.MIN_VALUE);
        Assert.assertFalse(solution.isValidBST(root));

    }

    @Test
    public void test_isValidBST_t9() {
        ValidateBst solution = new ValidateBst();
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        Assert.assertFalse(solution.isValidBST(root));

    }
}
