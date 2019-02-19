package com.arun.practise.trees;

import org.junit.Test;

import java.util.Stack;

public class PreorderTraversal {

    void traverseRecur(TreeNode curr) {
        if (curr == null)
            return;

        System.out.print(curr.val + " ");
        traverseRecur(curr.left);
        traverseRecur(curr.right);
    }


    void traverseIterative(TreeNode curr) {

        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.print(curr.val + " ");
                if (curr.right != null)
                    stack.push(curr.right);
                curr = curr.left;
            } else {
                curr = stack.pop();
            }
        }
    }

    @Test
    public void test_traverseRecur() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        BTreePrinter.printNode(root);
        PreorderTraversal solution = new PreorderTraversal();
        solution.traverseRecur(root);
    }

    @Test
    public void test_traverseIterative() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        BTreePrinter.printNode(root);
        PreorderTraversal solution = new PreorderTraversal();
        solution.traverseIterative(root);
    }
}


