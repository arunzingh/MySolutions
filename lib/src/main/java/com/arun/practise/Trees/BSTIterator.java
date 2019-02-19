package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

//    public BSTIterator(TreeNode root) {
//        TreeNode curr = root;
//        while (curr != null) {
//            stack.push(curr);
//            curr = curr.left;
//        }
//    }

    public void setRoot(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode curr = stack.pop();
        int val = curr.val;

        curr = curr.right;

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        return val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Test
    public void test_BSTIterator() {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);


        BSTIterator solution = new BSTIterator();
        solution.setRoot(root);

        Assert.assertEquals(3, solution.next());
        Assert.assertEquals(7, solution.next());
        Assert.assertTrue(solution.hasNext());
        Assert.assertEquals(9, solution.next());
        Assert.assertTrue(solution.hasNext());
        Assert.assertEquals(15, solution.next());
        Assert.assertTrue(solution.hasNext());
        Assert.assertEquals(20, solution.next());
        Assert.assertFalse(solution.hasNext());

    }
}
