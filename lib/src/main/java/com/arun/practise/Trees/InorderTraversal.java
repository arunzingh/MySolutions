package com.arun.practise.trees;

import org.junit.Test;

import java.util.Stack;

public class InorderTraversal {

    void traverseRecur(TreeNode curr) {
        if (curr == null) {
            return;
        }

        traverseRecur(curr.left);
        System.out.print(curr.val + " ");
        traverseRecur(curr.right);

    }

    void traverseIterative(TreeNode curr) {
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                System.out.print(temp.val + " ");
                curr = temp.right;
            }
        }
    }

    @Test
    public void test_traverseRecur() {
        InorderTraversal solution = new InorderTraversal();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);

        BTreePrinter.printNode(root);
        solution.traverseRecur(root);
    }

    @Test
    public void test_traverseIterative() {
        InorderTraversal solution = new InorderTraversal();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);

        BTreePrinter.printNode(root);
        solution.traverseIterative(root);
    }
}
