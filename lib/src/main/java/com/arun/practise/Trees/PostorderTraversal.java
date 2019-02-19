package com.arun.practise.trees;

import org.junit.Test;

import java.util.Stack;

public class PostorderTraversal {

    void traverseRecur(TreeNode curr) {
        if (curr == null) {
            return;
        }

        traverseRecur(curr.left);
        traverseRecur(curr.right);
        System.out.print(curr.val + " ");
    }

    void traverseIterative(TreeNode curr) {
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                if (curr.right != null)
                    stack.push(curr.right);
                curr = curr.left;
            } else {

            }
        }
    }

    @Test
    public void test_traverseRecur() {
        PostorderTraversal solution = new PostorderTraversal();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        BTreePrinter.printNode(root);

        solution.traverseRecur(root);
    }
}
