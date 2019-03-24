package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

public class CountUnivalueSubtrees {

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countUnivalSubtreesUtil(root);
        return count;

    }

    private boolean countUnivalSubtreesUtil(TreeNode curr) {
        if (curr == null) {
            return true;
        }

        boolean left = countUnivalSubtreesUtil(curr.left);
        boolean right = countUnivalSubtreesUtil(curr.right);

        if (left && right) {
            if (curr.left != null && curr.left.val != curr.val) {
                return false;
            }

            if (curr.right != null && curr.right.val != curr.val) {
                return false;
            }

            count++;
            return true;
        }

        return false;
    }

    @Test
    public void test_countUnivalSubtrees() {
        CountUnivalueSubtrees solution = new CountUnivalueSubtrees();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5 );
        root.right.right = new TreeNode(5);

        Assert.assertEquals(4, solution.countUnivalSubtrees(root));

    }
}
