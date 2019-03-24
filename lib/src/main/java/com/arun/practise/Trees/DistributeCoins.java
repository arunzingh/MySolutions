package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

public class DistributeCoins {

    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        distributeCoinsUtil(root);
        return moves;
    }

    private int distributeCoinsUtil(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int left = distributeCoinsUtil(curr.left);
        int right = distributeCoinsUtil(curr.right);

        moves += Math.abs(left) + Math.abs(right);

        curr.val += left;
        curr.val += right;

        return curr.val - 1;
    }

    @Test
    public void test_distributeCoins() {
        DistributeCoins solution = new DistributeCoins();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        Assert.assertEquals(2, solution.distributeCoins(root));
    }

    @Test
    public void test_distributeCoins_t2() {
        DistributeCoins solution = new DistributeCoins();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);
        Assert.assertEquals(3, solution.distributeCoins(root));
    }

    @Test
    public void test_distributeCoins_t3() {
        DistributeCoins solution = new DistributeCoins();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        Assert.assertEquals(2, solution.distributeCoins(root));
    }

    @Test
    public void test_distributeCoins_t4() {
        DistributeCoins solution = new DistributeCoins();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(3);

        Assert.assertEquals(4, solution.distributeCoins(root));
    }
}
